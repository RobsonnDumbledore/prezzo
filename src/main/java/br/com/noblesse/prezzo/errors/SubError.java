package br.com.noblesse.prezzo.errors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Robson
 */
@Getter
@Setter
@NoArgsConstructor
public class SubError {

    private String field;
    private String message;

    public SubError(String field, String message) {
        this.field = field;
        this.message = message;
    }

}
