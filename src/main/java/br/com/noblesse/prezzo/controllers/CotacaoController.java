package br.com.noblesse.prezzo.controllers;

import br.com.noblesse.prezzo.entities.Cotacao;
import br.com.noblesse.prezzo.services.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Robson
 */
@RestController
@RequestMapping("/api/cotacoes")
public class CotacaoController {

    @Autowired
    private CotacaoService service;

    @GetMapping
    public Page<Cotacao> cotacoes(@RequestParam Long empresaId, 
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        return service.cotacoes(empresaId, page, size);
    }

    @PutMapping
    public Cotacao update(@RequestBody Cotacao cotacao) {
        return service.update(cotacao);
    }

}
