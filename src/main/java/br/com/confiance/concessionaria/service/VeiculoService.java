package br.com.confiance.concessionaria.service;

import br.com.confiance.concessionaria.model.dto.VeiculoDTO;
import br.com.confiance.concessionaria.model.dto.CreateVeiculo;

import java.util.List;

public interface VeiculoService {

    List<VeiculoDTO> buscarVeiculosPorMarca(int codMarca);

    List<VeiculoDTO> buscarVeiculosPorModelo(int codModelo);

    List<VeiculoDTO> buscarVeiculoPorAno(int codMarca, int codModelo, Long ano);

    List<VeiculoDTO> buscarVeiculoPorCor(int codMarca, int codModelo, Long ano, int codCor);

    List<VeiculoDTO> buscarVeiculosPorFilial(int codFilial);

    VeiculoDTO buscarVeiculoPorPlaca(String placa);

    VeiculoDTO cadastrarVeiculo(CreateVeiculo veiculoNovo);
}
