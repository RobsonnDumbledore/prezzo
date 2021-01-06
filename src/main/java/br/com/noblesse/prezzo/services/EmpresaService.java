package br.com.noblesse.prezzo.services;

import br.com.noblesse.prezzo.entities.Empresa;
import br.com.noblesse.prezzo.exceptions.EntityNotFoundException;
import br.com.noblesse.prezzo.repositories.EmpresaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public Empresa save(Empresa empresa) {
        return repository.save(empresa);
    }
    
    public void update(Empresa empresa) {
        repository.save(empresa);
    }
    
    public List<Empresa> findAll() {
        return repository.findAll();
    }
    
    public Empresa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
    } 

}
