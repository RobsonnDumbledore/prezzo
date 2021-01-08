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
public class InvalidPasswordException extends RuntimeException{

    public InvalidPasswordException() {
        super("CREDENCIAIS INVÁLIDAS");
    }
    
}
