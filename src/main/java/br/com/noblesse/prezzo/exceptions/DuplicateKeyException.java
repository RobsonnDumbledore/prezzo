/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.noblesse.prezzo.exceptions;

/**
 *
 * @author Robson
 */
public class DuplicateKeyException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DuplicateKeyException(String msg) {
        super(msg);
    }
    
    
    
}
