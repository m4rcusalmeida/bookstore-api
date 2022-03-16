package br.com.bookstore.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bookstore.domain.Categoria;

public class CategoriaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String descricao;

	public CategoriaDto() {
	}

	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static List<CategoriaDto> converter(List<Categoria> list) {
		return list.stream().map(CategoriaDto::new).collect(Collectors.toList());
	}

}
