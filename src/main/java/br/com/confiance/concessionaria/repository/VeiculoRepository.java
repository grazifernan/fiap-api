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
}
