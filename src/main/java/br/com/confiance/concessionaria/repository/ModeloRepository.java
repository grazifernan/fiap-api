package br.com.confiance.concessionaria.repository;

import br.com.confiance.concessionaria.model.entity.Marca;
import br.com.confiance.concessionaria.model.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

    List<Modelo> findAllBycodMarca(Marca marca);

    List<Modelo> findAll();
}
