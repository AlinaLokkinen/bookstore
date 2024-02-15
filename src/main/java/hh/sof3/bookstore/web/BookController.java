package hh.sof3.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.CategoryRepository;


@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET) 
    public String homePage() {

        return "index"; // .html
    }

    @RequestMapping(value = "/booklist", method = RequestMethod.GET) 
    public String bookList(Model model) {

        List<Book> books = (List<Book>) bookRepository.findAll();
        
        model.addAttribute("books", books);

        return "booklist"; // .html
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String addNewBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());

        return "addbook"; // .html
    }

    @RequestMapping(value = "/savebook", method = RequestMethod.POST) 
    public String saveCar(@ModelAttribute Book book) {

        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);

        return "redirect:/booklist"; 
    }

    @RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {

        model.addAttribute("book", bookRepository.findById(bookId));

        return "editbook"; // .html
    }

}
