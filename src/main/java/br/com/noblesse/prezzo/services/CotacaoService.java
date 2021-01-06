package br.com.noblesse.prezzo.services;

import br.com.noblesse.prezzo.dto.PageDto;
import br.com.noblesse.prezzo.entities.Cotacao;
import br.com.noblesse.prezzo.repositories.CotacaoRepository;
import org.modelmapper.ModelMapper;
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

    public PageDto<Cotacao> findAll(Long empresaId, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Cotacao> cotacoes = repository.findAllByEmpresaId(empresaId, pageable);
        return convertToPageDto(cotacoes);
    }

    public Cotacao update(Cotacao cotacao) {
        return repository.save(cotacao);
    }

    private PageDto<Cotacao> convertToPageDto(Page<Cotacao> cotacoes) {
        PageDto<Cotacao> pageDto = new PageDto<>();
        pageDto.setContent(cotacoes.getContent());
        pageDto.setTotalElements(cotacoes.getTotalElements());
        pageDto.setTotalPages(cotacoes.getTotalPages());
        return pageDto;
    }

}
