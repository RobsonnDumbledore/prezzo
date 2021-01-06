package br.com.noblesse.prezzo.repositories;

import br.com.noblesse.prezzo.entities.Cotacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {

    Page<Cotacao> findAllByEmpresaId(Long empresaId, Pageable pageable);
}
