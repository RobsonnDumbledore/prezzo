package br.com.noblesse.prezzo.security;

import br.com.noblesse.prezzo.services.UsuarioService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Robson
 */
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioService usuarioService;

    public JwtAuthFilter(JwtService jwtService, UsuarioService usuarioService) {
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpRequest, HttpServletResponse httpResponse,
            FilterChain filterChain) throws ServletException, IOException {

        String authorization = httpRequest.getHeader("Authorization");

        if (authorization != null && authorization.startsWith("Bearer")) {
            String token = authorization.split(" ")[1];
            Boolean isValid = jwtService.validToken(token);
            if (isValid) {
                String email = jwtService.getEmailByUser(token);
                UserDetails usuario = usuarioService.loadUserByUsername(email);
                UsernamePasswordAuthenticationToken user
                        = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                user.setDetails(new WebAuthenticationDetailsSource()
                        .buildDetails(httpRequest));

                SecurityContextHolder.getContext().setAuthentication(user);

            }
        }
        filterChain.doFilter(httpRequest, httpResponse);
    }

}
