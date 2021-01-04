package br.com.noblesse.prezzo.repositories;

import br.com.noblesse.prezzo.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
