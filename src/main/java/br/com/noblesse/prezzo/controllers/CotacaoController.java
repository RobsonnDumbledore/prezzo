package br.com.noblesse.prezzo.controllers;

import br.com.noblesse.prezzo.entities.Cotacao;
import br.com.noblesse.prezzo.services.CotacaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Cotacao> cotacoes(@RequestParam Long empresaId) {
        return service.cotacoes(empresaId);
    }

    @PutMapping
    public Cotacao update(@RequestBody Cotacao cotacao) {
        return service.update(cotacao);
    }

}
