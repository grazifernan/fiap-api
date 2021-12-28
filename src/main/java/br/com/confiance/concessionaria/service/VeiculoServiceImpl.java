package br.com.confiance.concessionaria.service;

import br.com.confiance.concessionaria.model.dto.*;
import br.com.confiance.concessionaria.model.entity.*;
import br.com.confiance.concessionaria.repository.*;
import org.springframework.stereotype.Service;
import br.com.confiance.concessionaria.repository.MarcaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final MarcaRepository marcaRepository;
    private final ModeloRepository modeloRepository;
    private final FilialRepository filialRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository, MarcaRepository marcaRepository,
                              ModeloRepository modeloRepository, FilialRepository filialRepository){

        this.veiculoRepository = veiculoRepository;
        this.marcaRepository = marcaRepository;
        this.modeloRepository = modeloRepository;
        this.filialRepository = filialRepository;
    }

    @Override
    public List<VeiculoDTO> buscarVeiculosPorMarca(int codMarca){

        List<Veiculo> veiculoList;
        Marca marca = new Marca();
        marca.setCodMarca(codMarca);
        List<Modelo> modelo;
        modelo = modeloRepository.findAllBycodMarca(marca);

        if (codMarca > 0){

            veiculoList = veiculoRepository.findAllByCodModeloIn(modelo);
        }else{
            veiculoList = veiculoRepository.findAll();
        }

        return veiculoList.stream()
                .map(veiculo -> new VeiculoDTO(veiculo) )
                .collect(Collectors.toList());

    }

    @Override
    public List<VeiculoDTO> buscarVeiculosPorModelo(int codModelo){

        List<Veiculo> veiculoList;
        Modelo modelo = new Modelo();
        modelo.setCodModelo(codModelo);

        if (codModelo > 0){

            veiculoList = veiculoRepository.findAllByCodModelo(modelo);
        }else{
            veiculoList = veiculoRepository.findAll();
        }

        return veiculoList.stream()
                .map(veiculo -> new VeiculoDTO(veiculo) )
                .collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDTO> buscarVeiculoPorAno(int codMarca, int codModelo, Long ano){

        List<Veiculo> veiculoList;
        Marca marca = new Marca();
        marca.setCodMarca(codMarca);
        Modelo modelo = new Modelo();
        modelo.setCodModelo(codModelo);
        modelo.setAno(ano);
        modelo.setCodMarca(marca);


        //ALTERAÇÕES PENDENTES: mudar o ano para uma constante
        if (codModelo > 0 && codMarca > 0 && ano > 1900){

            veiculoList = veiculoRepository.findAllByCodModelo(modelo);
        }else{
            veiculoList = veiculoRepository.findAll();
        }

        return veiculoList.stream()
                .map(veiculo -> new VeiculoDTO(veiculo) )
                .collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDTO> buscarVeiculoPorCor(int codMarca, int codModelo, Long ano, int codCor){

        List<Veiculo> veiculoList;
        Marca marca = new Marca();
        marca.setCodMarca(codMarca);
        Cor cor = new Cor();
        cor.setCodCor(codCor);
        Modelo modelo = new Modelo();
        modelo.setCodModelo(codModelo);
        modelo.setAno(ano);
        modelo.setCodMarca(marca);

        if (codModelo > 0 && codMarca > 0 && codCor > 0){

            veiculoList = veiculoRepository.findByCodModeloAndCodCor(modelo, cor);
        }else{
            veiculoList = veiculoRepository.findAll();
        }

        return veiculoList.stream()
                .map(veiculo -> new VeiculoDTO(veiculo) )
                .collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDTO> buscarVeiculosPorFilial(int codFilial){

        List<Veiculo> veiculoList;
        Filial filial = new Filial();
        filial.setcodFilial(codFilial);

        if (codFilial > 0 ){

            veiculoList = veiculoRepository.findAllByCodFilial(filial);
        }else{
            veiculoList = veiculoRepository.findAll();
        }

        return veiculoList.stream()
                .map(veiculo -> new VeiculoDTO(veiculo) )
                .collect(Collectors.toList());
    }

    @Override
    public VeiculoDTO buscarVeiculoPorPlaca(String placa){

        Veiculo veiculo;
        veiculo = veiculoRepository.findByPlaca(placa);
        return new VeiculoDTO(veiculo);
    }


    @Override
    public VeiculoDTO cadastrarVeiculo(CreateVeiculoDTO veiculoNovo) {

        Modelo modelo = new Modelo();
        modelo.setCodModelo(veiculoNovo.getCodModelo());

        Cor cor = new Cor();
        cor.setCodCor(veiculoNovo.getCodCor());

        Filial filial = new Filial();
        filial.setcodFilial(veiculoNovo.getCodFilial());

        Veiculo veiculo = new Veiculo();
        veiculo.setCodModelo(modelo);
        veiculo.setCodCor(cor);
        veiculo.setCodFilial(filial);
        veiculo.setDescricao(veiculoNovo.getDescricao());
        veiculo.setPlaca(veiculoNovo.getPlaca());
        veiculo.setKm(veiculoNovo.getKm());
        veiculo.setValor(veiculoNovo.getValor());
        veiculo.setRenavam(veiculoNovo.getRenavam());

       // Veiculo veiculo = new Veiculo(veiculoNovo);
        Veiculo savedVeiculo = veiculoRepository.save(veiculo);
        return new VeiculoDTO(savedVeiculo);
    }

    @Override
    public MarcaDTO buscarMarcaPorCodigo(int codMarca){
        Marca marca;

        marca = marcaRepository.findAllBycodMarca(codMarca);
        return new MarcaDTO(marca);
    }

    @Override
    public List<MarcaDTO> listarMarcas(){

        List<Marca> marcaList;
        marcaList = marcaRepository.findAll();

        return marcaList.stream()
                .map(marca -> new MarcaDTO(marca) )
                .collect(Collectors.toList());
    }

    @Override
    public List<ModeloDTO> buscarModeloPorMarca(int codMarca){

        List<Modelo> modeloList;
        Marca marca = new Marca();
        marca.setCodMarca(codMarca);

        modeloList = modeloRepository.findAllBycodMarca(marca);

        return modeloList.stream()
                .map(modelo -> new ModeloDTO(modelo) )
                .collect(Collectors.toList());
    };

    @Override
    public List<ModeloDTO> listarModelos(){

        List<Modelo> modeloList;
        modeloList = modeloRepository.findAll();

        return modeloList.stream()
                .map(modelo -> new ModeloDTO(modelo) )
                .collect(Collectors.toList());

    };

    @Override
    public FilialDTO buscarFilialPorCodigo(int codFilial){

        Filial filial;
        filial = filialRepository.findBycodFilial(codFilial);
        return new FilialDTO(filial);

    };

    @Override
    public List<FilialDTO> listarFiliais(){

        List<Filial> filialList;
        filialList = filialRepository.findAll();

        return filialList.stream()
                .map(filial -> new FilialDTO(filial) )
                .collect(Collectors.toList());

    };


}
