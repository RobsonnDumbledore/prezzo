package br.com.noblesse.prezzo.exceptions;

/**
 *
 * @author Robson
 */
public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String msg) {
        super(msg);
    }
    
}
