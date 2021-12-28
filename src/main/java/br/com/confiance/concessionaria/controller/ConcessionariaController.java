package br.com.confiance.concessionaria.controller;

import br.com.confiance.concessionaria.model.dto.CreateVeiculoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.confiance.concessionaria.model.dto.VeiculoDTO;
import br.com.confiance.concessionaria.service.VeiculoService;

import java.util.List;

@RestController
@RequestMapping("veiculos")
public class ConcessionariaController {

    private VeiculoService veiculoService;

    public ConcessionariaController(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    @GetMapping("/marca/{codMarca}")
    public List<VeiculoDTO> buscarVeiculosPorMarca(@PathVariable int codMarca){
        return veiculoService.buscarVeiculosPorMarca(codMarca);
    }

    @GetMapping("/modelo/{codModelo}")
    public List<VeiculoDTO> buscarVeiculosPorModelo(@PathVariable int codModelo){
        return veiculoService.buscarVeiculosPorModelo(codModelo);
    }

    @GetMapping("/ano/{codMarca}/{codModelo}/{ano}")
    public List<VeiculoDTO> buscarVeiculoPorAno(@PathVariable int codMarca, @PathVariable int codModelo,
                                                @PathVariable Long ano){
        return veiculoService.buscarVeiculoPorAno(codMarca, codModelo, ano);
    }

    @GetMapping("/cor/{codMarca}/{codModelo}/{ano}/{codCor}")
    public List<VeiculoDTO> buscarVeiculoPorCor(@PathVariable int codMarca, @PathVariable int codModelo,
                                                @PathVariable Long ano, @PathVariable int codCor){
        return veiculoService.buscarVeiculoPorCor( codMarca,  codModelo,  ano, codCor);

    }

    @GetMapping("/filial/{codFilial}")
    public List<VeiculoDTO> buscarVeiculosPorFilial(@PathVariable int codFilial){
        return veiculoService.buscarVeiculosPorFilial(codFilial);
    }

    @GetMapping("/placa/{placa}")
    public VeiculoDTO buscarVeiculoPorPlaca(@PathVariable String placa){
        return veiculoService.buscarVeiculoPorPlaca(placa);
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
