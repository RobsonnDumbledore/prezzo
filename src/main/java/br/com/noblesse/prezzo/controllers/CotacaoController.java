package br.com.noblesse.prezzo.controllers;

import br.com.noblesse.prezzo.dto.CotacaoDto;
import br.com.noblesse.prezzo.dto.PageDto;
import br.com.noblesse.prezzo.entities.Cotacao;
import br.com.noblesse.prezzo.services.CotacaoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public PageDto<CotacaoDto> cotacoes(@RequestParam Long empresaId,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        return service.findAll(empresaId, page, size);
    }

    @PutMapping
    @ResponseStatus(OK)
    public void update(@RequestBody @Valid Cotacao cotacao) {
        service.update(cotacao);
    }

}
