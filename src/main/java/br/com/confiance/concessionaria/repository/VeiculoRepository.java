package br.com.confiance.concessionaria.repository;

import br.com.confiance.concessionaria.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    List<Veiculo> findAllByCodModeloIn(List<Modelo> modelo);
    List<Veiculo> findAll();
    List<Veiculo> findAllByCodModelo(Modelo modelo);
    List<Veiculo> findByCodModeloAndCodCor(Modelo modelo, Cor cor);
    List<Veiculo> findAllByCodFilial(Filial filial);
    Veiculo findByPlaca(String placa);

    @Query(value = "SELECT * FROM veiculo veiculo\n" +
            "INNER JOIN modelo_veiculo model ON veiculo.cod_modelo = model.cod_modelo\n" +
            "INNER JOIN marca_veiculo marca ON marca.cod_marca = model.cod_marca\n" +
            "WHERE (?1 = 0 OR marca.cod_marca = ?1) AND (?2 = 0 OR veiculo.cod_modelo = ?2)\n" +
            "AND (?3 = 0 OR model.ano = ?3) AND (?4 = 0 OR veiculo.cod_empresa = ?4)\n" +
            "AND (?5 = 0 OR veiculo.cod_cor = ?5)", nativeQuery = true)
    List<Veiculo> findAllByCustomQuery(int codMarca, int codModelo, int ano, int codEmpresa, int codCor);

}
