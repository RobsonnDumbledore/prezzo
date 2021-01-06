package br.com.noblesse.prezzo.dto;

import br.com.noblesse.prezzo.entities.Produto;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Robson
 */
@Getter
@Setter
public class CotacaoDto {
    private Long id;
    private Produto produto;
    private Float preco;
}
