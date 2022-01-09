package br.com.confiance.concessionaria.repository;

import br.com.confiance.concessionaria.model.entity.Cor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorRepository extends JpaRepository<Cor, Integer> {
    List<Cor> findAll();
    Cor findBycodCor(int codCor);
}
