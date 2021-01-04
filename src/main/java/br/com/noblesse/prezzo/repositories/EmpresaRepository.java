package br.com.noblesse.prezzo.repositories;

import br.com.noblesse.prezzo.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
}
