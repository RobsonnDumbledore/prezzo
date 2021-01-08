package br.com.noblesse.prezzo.security;

import br.com.noblesse.prezzo.entities.Usuario;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Robson
 */
@Getter
@Setter
public class CustomUserDetail extends User {

    private Usuario usuario;

    public CustomUserDetail(
            Usuario usuario, 
            String username, 
            String password, 
            Collection<? extends GrantedAuthority> authorities) {
        
        super(username, password, authorities);
        this.usuario = usuario;
    }

}
