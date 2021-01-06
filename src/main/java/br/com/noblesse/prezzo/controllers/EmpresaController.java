package br.com.noblesse.prezzo.controllers;

import br.com.noblesse.prezzo.entities.Empresa;
import br.com.noblesse.prezzo.services.EmpresaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Robson
 */
@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public Empresa save(@RequestBody Empresa empresa) {
        return service.save(empresa);
    }
    
    @GetMapping
    @ResponseStatus(OK)
    public List<Empresa> findAll() {
        return service.findAll();
    }

    @PutMapping
    @ResponseStatus(OK)
    public void update(@RequestBody Empresa empresa) {
        service.update(empresa);
    }

    @GetMapping("{id}")
    @ResponseStatus(OK)
    public Empresa findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
