package br.com.confiance.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.confiance.concessionaria.model.entity.Veiculo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    @Query(nativeQuery=true, value = "select v.*" +
            " from veiculo v " +
            " ,modelo_veiculo m" +
            " where v.cod_modelo = m.cod_modelo" +
            " and m.cod_marca = :codMarca")
    List<Veiculo> buscarVeiculosPorMarca(int codMarca);


    @Query(nativeQuery=true, value = "select v.*" +
            " from veiculo v " +
            " ,modelo_veiculo m " +
            " where v.cod_modelo = m.cod_modelo" +
            " and m.cod_modelo = :codModelo")
    List<Veiculo> buscarVeiculosPorModelo(int codModelo);

    @Query(nativeQuery=true, value = "select v.*" +
            " from veiculo v " +
            " ,modelo_veiculo m" +
            " where v.cod_modelo = m.cod_modelo" +
            " and m.cod_modelo = :codModelo" +
            " and m.cod_marca = :codMarca" +
            " and m.ano >= :ano")
    List<Veiculo> buscarVeiculoPorAno(int codMarca, int codModelo, Long ano);

    @Query(nativeQuery=true, value = "select v.*" +
            " from veiculo v " +
            " ,modelo_veiculo m" +
            " where v.cod_modelo = m.cod_modelo" +
            " and m.cod_modelo = :codModelo" +
            " and m.cod_marca = :codMarca" +
            " and m.ano >= :ano" +
            " and v.cod_cor = :codCor")
    List<Veiculo> buscarVeiculoPorCor(int codMarca, int codModelo, Long ano, int codCor);

    @Query(nativeQuery=true, value ="select v.* from veiculo v where v.cod_empresa = :cod")
    List<Veiculo> buscarVeiculosPorFilial(int cod);

    @Query(nativeQuery=true, value = " select v.* from veiculo v where v.placa = :placa")
    Veiculo buscarVeiculoPorPlaca(String placa);

}
