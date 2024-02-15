package hh.sof3.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			Book book1 = new Book("ekakirja", "eka kirjailija", 2000, "930505", 15.0);
			Book book2 = new Book("tokakirja", "toka kirjailija", 2021, "929065", 15.2);

			bookRepository.save(book1);
			bookRepository.save(book2);

			Category cat1 = new Category(1, "horror");
			Category cat2 = new Category(2, "romance");

			categoryRepository.save(cat1);
			categoryRepository.save(cat2);

		};

	
	}

}
