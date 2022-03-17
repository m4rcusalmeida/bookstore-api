package br.com.bookstore.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookstore.domain.Categoria;
import br.com.bookstore.dtos.CategoriaDto;
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

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Categoria create(Categoria cat) {
		cat.setId(null);
		return repository.save(cat);
	}

	@Transactional
	public Categoria update(Long id, CategoriaDto catDto) {
		Categoria categoria = findById(id);
		categoria.setNome(catDto.getNome());
		categoria.setDescricao(catDto.getDescricao());
		return repository.save(categoria);
	}

	public void delete(Long id) {
		Categoria categoria = findById(id);
		repository.delete(categoria);
	}
}
