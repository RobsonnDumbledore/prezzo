package br.com.noblesse.prezzo.services;

import br.com.noblesse.prezzo.entities.Usuario;
import br.com.noblesse.prezzo.exceptions.DuplicateKeyException;
import br.com.noblesse.prezzo.exceptions.EntityNotFoundException;
import br.com.noblesse.prezzo.exceptions.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.noblesse.prezzo.repositories.UsuarioRepository;
import br.com.noblesse.prezzo.security.CustomUserDetail;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
                .orElseThrow(() -> new UsernameNotFoundException("CREDENCIAIS INVÁLIDAS"));

        List<String> permissoes = new ArrayList<>();
        return new CustomUserDetail(usuario, usuario.getEmail(), usuario.getSenha(), getPermissoes(permissoes));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(List<String> permissoes) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        permissoes.forEach(p -> authorities.add(new SimpleGrantedAuthority(p)));
        return authorities;
    }

    public UserDetails authenticate(Usuario usuario) {
        UserDetails user = loadUserByUsername(usuario.getEmail());
        Boolean passwordsMatch = encoder.matches(usuario.getSenha(), user.getPassword());
        if (passwordsMatch) {
            return user;
        }
        throw new InvalidPasswordException();
    }

}
