package br.com.confiance.concessionaria.repository;

import br.com.confiance.concessionaria.model.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    Marca findAllBycodMarca(int CodMarca);
    List<Marca> findAll();

}
