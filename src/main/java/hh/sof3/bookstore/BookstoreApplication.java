package hh.sof3.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;
import hh.sof3.bookstore.domain.User;
import hh.sof3.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			
			log.info("creating categories");
			Category cat1 = new Category(1, "horror");
			Category cat2 = new Category(2, "romance");
			Category cat3 = new Category(3, "mystery");

			log.info("saving categories to repository");
			categoryRepository.save(cat1);
			categoryRepository.save(cat2);
			categoryRepository.save(cat3);

			log.info("create books");
			Book book1 = new Book("eka", "eka", 2032, "993941", 14.5, cat1);
			Book book2 = new Book("toka", "toka", 2940, "939502", 64.2, cat2);
			Book book3 = new Book("kolmas", "kolmas", 2944, "959652", 43.5, null);
			Book book4 = new Book("neljäs", "neljäs", 3421, "923858", 34.23, cat1);

			log.info("save books to repository");
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
			
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

			// create users (firstpassword, secondpassword)
			User user1 = new User("user", "$2a$10$j2mMSIWjPUu5KCLJCfQHguYeTP7UKYZs9q0.tCWAaFjhF.1FMJ4N2", "USER");
			User user2 = new User("someOtherUser", "$2a$10$IAWOpU5NlhEOE2y/t7o/puYhm2vBpwh3QoIz8G1959F6vvz7ywTHu", "ADMIN");

			userRepository.save(user1);
			userRepository.save(user2);

		};

	
	}

}
