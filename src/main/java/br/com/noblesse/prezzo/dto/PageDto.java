package br.com.noblesse.prezzo.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Robson
 * @param <T>
 */
@Getter
@Setter
@NoArgsConstructor
public class PageDto<T> {

    private Long totalElements;
    private Integer totalPages;
    private List<T> content;

    public PageDto(Long totalElements, Integer totalPages, List<T> content) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.content = content;
    }
}
