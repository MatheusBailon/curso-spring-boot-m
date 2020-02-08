package br.com.babypet.utils.models;

import java.util.List;

import org.springframework.data.domain.Page;

public class PageModel<T, M> {
	
	private Long totalElementos;
	private Integer totalPages;
	private Integer pageSize;
	private Integer pageNumber;
	private List<M> content;
	
	
	
	
	public List<M> getContent() {
		return content;
	}




	public Long getTotalElementos() {
		return totalElementos;
	}




	public Integer getTotalPages() {
		return totalPages;
	}




	public Integer getPageSize() {
		return pageSize;
	}




	public Integer getPageNumber() {
		return pageNumber;
	}




	public void setContetPage(Page<T> page) {
		this.totalElementos=page.getTotalElements();
		this.pageSize=page.getSize();
		this.pageNumber = page.getNumber();
		this.totalPages = page.getTotalPages();
	}
	
	
	public void setContentList(List<M> contents) {
		this.content = contents;
	}

}
