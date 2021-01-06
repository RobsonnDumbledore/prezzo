package br.com.noblesse.prezzo.repositories;

import br.com.noblesse.prezzo.entities.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
    Boolean existsByEmail(String email);
}
