package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof3.bookstore.web.BookController;
import hh.sof3.bookstore.web.BookRestController;
import hh.sof3.bookstore.web.CategoryController;

@SpringBootTest
public class BookstoreApplicationTests {

@Autowired
private BookController bookController;

@Autowired
private BookRestController bookRestController;

@Autowired
private CategoryController categoryController;

	@Test
	void bookControllerNotNull() {
		assertThat(bookController).isNotNull();
		
	}

	@Test
	void bookRestControllerNotNull() {
		assertThat(bookRestController).isNotNull();		
	}

	@Test
	void categoryControllerNotNull() {
		assertThat(categoryController).isNotNull();

	}

}
