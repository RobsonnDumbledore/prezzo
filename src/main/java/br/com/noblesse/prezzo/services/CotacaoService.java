package br.com.noblesse.prezzo.services;

import br.com.noblesse.prezzo.entities.Cotacao;
import br.com.noblesse.prezzo.repositories.CotacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service
public class CotacaoService {
    
    @Autowired
    private CotacaoRepository repository;
    
    public List<Cotacao> cotacoes(Long empresaId){
        return repository.findAllByEmpresaId(empresaId);
    }
    
    public Cotacao update(Cotacao cotacao) {
        return repository.save(cotacao);
    }
    
}
