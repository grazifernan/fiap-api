package br.com.confiance.concessionaria.service;

import br.com.confiance.concessionaria.model.dto.CreateVeiculo;
import br.com.confiance.concessionaria.model.dto.VeiculoDTO;
import br.com.confiance.concessionaria.model.entity.*;
import br.com.confiance.concessionaria.service.VeiculoService;
import org.springframework.stereotype.Service;
import br.com.confiance.concessionaria.repository.VeiculoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository){

        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public List<VeiculoDTO> buscarVeiculosPorMarca(int codMarca){

        List<Veiculo> veiculoList;

        if (codMarca > 0){

            veiculoList = veiculoRepository.buscarVeiculosPorMarca(codMarca);
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

        if (codModelo > 0){

            veiculoList = veiculoRepository.buscarVeiculosPorModelo(codModelo);
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

        //ALTERAÇÕES PENDENTES: mudar o ano para uma constante
        if (codModelo > 0 && codMarca > 0 && ano > 1900){

            veiculoList = veiculoRepository.buscarVeiculoPorAno(codMarca, codModelo, ano);
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

        if (codModelo > 0 && codMarca > 0 && codCor > 0){

            veiculoList = veiculoRepository.buscarVeiculoPorCor(codMarca, codModelo, ano, codCor);
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

        if (codFilial > 0 ){

            veiculoList = veiculoRepository.buscarVeiculosPorFilial(codFilial);
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

       veiculo = veiculoRepository.buscarVeiculoPorPlaca(placa);
        return new VeiculoDTO(veiculo);
    }


    @Override
    public VeiculoDTO cadastrarVeiculo(CreateVeiculo veiculoNovo) {

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

}
