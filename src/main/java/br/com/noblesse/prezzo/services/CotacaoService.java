package br.com.noblesse.prezzo.services;

import br.com.noblesse.prezzo.entities.Cotacao;
import br.com.noblesse.prezzo.repositories.CotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service
public class CotacaoService {
    
    @Autowired
    private CotacaoRepository repository;
    
    public Page<Cotacao> cotacoes(Long empresaId, int page, int size){
        Pageable pageable = PageRequest.of(page - 1, size);
        return repository.findAllByEmpresaId(empresaId, pageable);
    }
    
    public Cotacao update(Cotacao cotacao) {
        return repository.save(cotacao);
    }
    
}
