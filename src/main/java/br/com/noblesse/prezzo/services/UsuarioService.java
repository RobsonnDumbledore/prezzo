package br.com.noblesse.prezzo.services;

import br.com.noblesse.prezzo.entities.Usuario;
import br.com.noblesse.prezzo.exceptions.DuplicateKeyException;
import br.com.noblesse.prezzo.exceptions.EntityNotFoundException;
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
        existsByEmail(usuario.getEmail());
        return repository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
    }

    public void existsByEmail(String email) {
        if (repository.existsByEmail(email)) {
            throw new DuplicateKeyException("email já cadastrado");
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
