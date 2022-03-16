package br.com.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookstore.domain.Categoria;
import br.com.bookstore.repository.CategoriaRepository;
import br.com.bookstore.service.exception.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Long id) {
		Optional<Categoria> optional = repository.findById(id);
		return optional.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado! " + "Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
