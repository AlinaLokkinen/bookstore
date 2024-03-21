package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findByTitleShouldReturnBook() {
        List<Book> books = bookRepository.findByTitle("eka");
        assertThat(books).hasSize(1);
    }

    @Test
    void findByAuthorShouldReturnBook() {
        List<Book> books = bookRepository.findByAuthor("eka");
        assertThat(books).hasSize(1);
    }

    @Test
    void createNewBook() {
        Book book = new Book("uusi", "tuntematon", 2352, "1234", 546.3, null);
        bookRepository.save(book);

        assertThat(book.getId()).isNotNull();
    }

    @Test 
    void deleteBook() {
        //  ????
    }
}
