package br.com.bookstore;

import java.util.Arrays;

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
		Categoria cat2 = new Categoria(null, "Direito", "Livros de Direito");
		Livro l2 = new Livro(null, "Vade Mecum", "Eveline Morais", "Manual do burro do direito", cat2);
		cat2.add(l2);
		Categoria cat3 = new Categoria(null, "Engenharia", "Livros de Engenharia");
		Livro l3 = new Livro(null, "Engenheiro Iniciante", "Toim Pedreiro", "Manual do burro do engenheiro", cat3);
		cat3.add(l3);
		Livro l4 = new Livro(null, "Teoria Geral do Processo", "Jose de Albuquerque Rocha", "Teoria do processo", cat2);
		cat2.add(l4);

		cr.saveAll(Arrays.asList(cat2, cat3));
		lr.saveAll(Arrays.asList(l2, l3, l4));

	}

}
