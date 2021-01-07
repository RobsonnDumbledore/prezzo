package br.com.noblesse.prezzo.services;

import br.com.noblesse.prezzo.entities.Usuario;
import br.com.noblesse.prezzo.exceptions.DuplicateKeyException;
import br.com.noblesse.prezzo.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.noblesse.prezzo.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service
public class UsuarioService implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository repository;
    
    @Autowired
    private PasswordEncoder encoder;
    
    public Usuario save(Usuario usuario) {
        existsByEmail(usuario.getEmail());
        usuario.setSenha(encoder.encode(usuario.getSenha()));
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
            throw new DuplicateKeyException("Email já cadastrado");
        }
    }
    
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
        return User
                .builder()
                .username(usuario.getEmail())
                .roles()
                .password(usuario.getSenha())
                .build();
    }
    
}
