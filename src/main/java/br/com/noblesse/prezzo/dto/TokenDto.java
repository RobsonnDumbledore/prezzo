package br.com.noblesse.prezzo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Robson
 */
@Getter
@Setter
@AllArgsConstructor
public class TokenDto {

    private String email;
    private String token;
    public TokenDto() {
    }

}
