package br.com.noblesse.prezzo.repositories;

import br.com.noblesse.prezzo.entities.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long>{
    
}
