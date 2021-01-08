/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.noblesse.prezzo.utils;

import br.com.noblesse.prezzo.entities.Usuario;
import br.com.noblesse.prezzo.security.CustomUserDetail;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Robson
 */
public class ContextUtil {

    public static Usuario getUser() {
        CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        Usuario usuario = userDetail.getUsuario();
        return usuario;
    }

}
