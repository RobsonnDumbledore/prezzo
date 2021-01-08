package br.com.noblesse.prezzo.security;

import br.com.noblesse.prezzo.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service
@Getter
@Setter
public class JwtService {

    @Value("${security.jwt.expiration}")
    private String expiration;

    @Value("${security.jwt.subscription-key}")
    private String subscriptionKey;

    public String generateToken(Usuario usuario) {
        long expString = Long.valueOf(this.expiration);
        LocalDateTime expirationDate = LocalDateTime.now().plusMinutes(expString);
        Instant instant = expirationDate.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        return Jwts
                .builder()
                .setSubject(usuario.getEmail())
                .setExpiration(data)
                .signWith(SignatureAlgorithm.HS512, subscriptionKey)
                .compact();
    }

    private Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(subscriptionKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean validToken(String token) {
        try {
            Claims claims = getClaims(token);
            Date expirationDate = claims.getExpiration();
            LocalDateTime data = expirationDate.toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(data);
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmailByUser(String token) throws ExpiredJwtException {
        return (String) getClaims(token).getSubject();
    }

}
