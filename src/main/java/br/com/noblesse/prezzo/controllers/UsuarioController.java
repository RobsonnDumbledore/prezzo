/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.noblesse.prezzo.controllers;

import br.com.noblesse.prezzo.entities.Usuario;
import br.com.noblesse.prezzo.services.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Robson
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public Usuario save(@RequestBody @Valid Usuario usuario) {
        return service.save(usuario);
    }

    @PutMapping
    @ResponseStatus(OK)
    public Usuario update(@RequestBody Usuario usuario) {
        return service.update(usuario);
    }

    @GetMapping("{id}")
    @ResponseStatus(OK)
    public Usuario findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
