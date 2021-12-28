package br.com.confiance.concessionaria.repository;

import br.com.confiance.concessionaria.model.entity.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilialRepository extends JpaRepository<Filial, Integer> {

    List<Filial> findAll();
    Filial findBycodFilial(int codFilial);

}
