package br.com.confiance.concessionaria.controller;

import br.com.confiance.concessionaria.model.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.confiance.concessionaria.service.VeiculoService;

import java.util.List;

@RestController
//assim que implementar o jwt, precisamos retirar esta annotation, pois ela desabilita o CORS
@CrossOrigin
@RequestMapping("veiculos")
public class ConcessionariaController {

    private VeiculoService veiculoService;

    public ConcessionariaController(VeiculoService veiculoService){

        this.veiculoService = veiculoService;
    }

    @GetMapping("/consultar/{codMarca}/{codModelo}/{ano}/{codEmpresa}/{codCor}")
    public List<VeiculoDTO> buscarVeiculos(@PathVariable int codMarca, @PathVariable int codModelo, @PathVariable int ano
                                        , @PathVariable int codEmpresa, @PathVariable int codCor){
        return veiculoService.buscarVeiculos(codMarca, codModelo, ano, codEmpresa, codCor);
    }

    @GetMapping("/consultapormarca/{codMarca}")
    public List<VeiculoDTO> buscarVeiculosPorMarca(@PathVariable int codMarca){
        return veiculoService.buscarVeiculosPorMarca(codMarca);
    }

    @GetMapping("/consultapormodelo/{codModelo}")
    public List<VeiculoDTO> buscarVeiculosPorModelo(@PathVariable int codModelo){
        return veiculoService.buscarVeiculosPorModelo(codModelo);
    }

    @GetMapping("/consultaporano/{codMarca}/{codModelo}/{ano}")
    public List<VeiculoDTO> buscarVeiculoPorAno(@PathVariable int codMarca, @PathVariable int codModelo,
                                                @PathVariable Long ano){
        return veiculoService.buscarVeiculoPorAno(codMarca, codModelo, ano);
    }

    @GetMapping("/consultaporcor/{codMarca}/{codModelo}/{ano}/{codCor}")
    public List<VeiculoDTO> buscarVeiculoPorCor(@PathVariable int codMarca, @PathVariable int codModelo,
                                                @PathVariable Long ano, @PathVariable int codCor){
        return veiculoService.buscarVeiculoPorCor( codMarca,  codModelo,  ano, codCor);

    }

    @GetMapping("/consultaporfilial/{codFilial}")
    public List<VeiculoDTO> buscarVeiculosPorFilial(@PathVariable int codFilial){
        return veiculoService.buscarVeiculosPorFilial(codFilial);
    }

    @GetMapping("/consultaporplaca/{placa}")
    public VeiculoDTO buscarVeiculoPorPlaca(@PathVariable String placa){
        return veiculoService.buscarVeiculoPorPlaca(placa);
    }

    @GetMapping("/listarmarcas")
    public List<MarcaDTO> listarMarcas(){
        return veiculoService.listarMarcas();
    }

    @GetMapping("/listarmodelos/{codMarca}")
    public List<ModeloDTO> buscarModeloPorMarca(@PathVariable int codMarca){
        return veiculoService.buscarModeloPorMarca(codMarca);
    }

    @GetMapping("/listarfiliais")
    public List<FilialDTO> listarFiliais(){
        return veiculoService.listarFiliais();
    }

    @GetMapping("/listarcores")
    public List<CorDTO> listarCores(){
        return veiculoService.listarCores();
    }

    @GetMapping("/buscarCor/{codCor}")
    public CorDTO buscarCor(@PathVariable int codCor){
        return veiculoService.buscarCor(codCor);
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoDTO cadastrarVeiculo(@RequestBody CreateVeiculoDTO createVeiculoDTO){

        createVeiculoDTO.setCodCor(createVeiculoDTO.getCodCor());
        createVeiculoDTO.setCodFilial(createVeiculoDTO.getCodFilial());
        createVeiculoDTO.setCodModelo(createVeiculoDTO.getCodModelo());
        createVeiculoDTO.setDescricao(createVeiculoDTO.getDescricao());
        createVeiculoDTO.setKm(createVeiculoDTO.getKm());
        createVeiculoDTO.setPlaca(createVeiculoDTO.getPlaca());
        createVeiculoDTO.setRenavam(createVeiculoDTO.getRenavam());
        createVeiculoDTO.setValor(createVeiculoDTO.getValor());
        createVeiculoDTO.setCodFilial(createVeiculoDTO.getCodFilial());

        return veiculoService.cadastrarVeiculo(createVeiculoDTO);
    }


}
