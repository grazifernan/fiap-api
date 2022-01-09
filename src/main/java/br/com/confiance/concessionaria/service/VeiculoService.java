package br.com.confiance.concessionaria.service;

import br.com.confiance.concessionaria.model.dto.*;

import java.util.List;

public interface VeiculoService {

    List<VeiculoDTO> buscarVeiculosPorMarca(int codMarca);

    List<VeiculoDTO> buscarVeiculosPorModelo(int codModelo);

    List<VeiculoDTO> buscarVeiculoPorAno(int codMarca, int codModelo, Long ano);

    List<VeiculoDTO> buscarVeiculoPorCor(int codMarca, int codModelo, Long ano, int codCor);

    List<VeiculoDTO> buscarVeiculosPorFilial(int codFilial);

    VeiculoDTO buscarVeiculoPorPlaca(String placa);

    VeiculoDTO cadastrarVeiculo(CreateVeiculoDTO veiculoNovo);

    MarcaDTO buscarMarcaPorCodigo(int codMarca);

    List<MarcaDTO> listarMarcas();

    List<ModeloDTO> buscarModeloPorMarca(int codMarca);

    List<ModeloDTO> listarModelos();

    List<FilialDTO> listarFiliais();

    List<CorDTO> listarCores();

    CorDTO buscarCor(int codCor);

    FilialDTO buscarFilialPorCodigo(int codFilial);
}
