package br.com.noblesse.prezzo.services;

import br.com.noblesse.prezzo.dto.CotacaoDto;
import br.com.noblesse.prezzo.dto.PageDto;
import br.com.noblesse.prezzo.entities.Cotacao;
import br.com.noblesse.prezzo.repositories.CotacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    @Autowired
    private ModelMapper modelMapper;

    @Cacheable("cotacoes")
    public PageDto<CotacaoDto> findAll(Long empresaId, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Cotacao> cotacoes = repository.findAllByEmpresaId(empresaId, pageable);
        Page<CotacaoDto> cotacoesDto = convertToListDto(cotacoes);
        return convertToPageDto(cotacoesDto);
    }

    public Cotacao update(Cotacao cotacao) {
        return repository.save(cotacao);
    }

    private CotacaoDto convertToDto(Cotacao cotacao) {
        return modelMapper.map(cotacao, CotacaoDto.class);
    }

    private Page<CotacaoDto> convertToListDto(Page<Cotacao> cotacoes) {
        return cotacoes.map(cotacao -> convertToDto(cotacao));
    }

    private PageDto<CotacaoDto> convertToPageDto(Page<CotacaoDto> cotacoes) {
        PageDto<CotacaoDto> pageDto = new PageDto<>();
        pageDto.setContent(cotacoes.getContent());
        pageDto.setTotalElements(cotacoes.getTotalElements());
        pageDto.setTotalPages(cotacoes.getTotalPages());
        return pageDto;
    }

}
