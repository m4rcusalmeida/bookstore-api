package br.com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
