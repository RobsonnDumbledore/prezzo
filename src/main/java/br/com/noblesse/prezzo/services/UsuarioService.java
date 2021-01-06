package br.com.noblesse.prezzo.services;

import br.com.noblesse.prezzo.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.noblesse.prezzo.repositories.UsuarioRepository;

import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario findById(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
