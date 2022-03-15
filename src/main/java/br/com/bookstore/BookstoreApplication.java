package br.com.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bookstore.domain.Categoria;
import br.com.bookstore.domain.Livro;
import br.com.bookstore.repository.CategoriaRepository;
import br.com.bookstore.repository.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository cr;

	@Autowired
	private LivroRepository lr;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		cat1.add(l1);

		cr.save(cat1);
		lr.save(l1);
	}

}
