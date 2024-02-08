package hh.sof3.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;


@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

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
    

}
