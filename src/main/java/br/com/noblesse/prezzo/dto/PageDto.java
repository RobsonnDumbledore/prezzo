package br.com.noblesse.prezzo.dto;

import java.util.List;

/**
 *
 * @author Robson
 * @param <T>
 */
public class PageDto<T> {

    private Long totalElements;
    private Integer totalPages;
    private List<T> content;

    public PageDto(Long totalElements, Integer totalPages, List<T> content) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.content = content;
    }

    public PageDto() {
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

}
