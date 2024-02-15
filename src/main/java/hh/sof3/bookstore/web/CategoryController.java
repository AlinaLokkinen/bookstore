package hh.sof3.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/categorylist", method = RequestMethod.GET)
    public String categoryList(Model model) {

        List<Category> categories = (List<Category>) categoryRepository.findAll();

        model.addAttribute("categories", categories);

        return "categorylist"; //.html
    }

    @RequestMapping(value = "/createcategory", method = RequestMethod.GET)
    public String createCategory(Model model) {

        model.addAttribute("category", new Category());

        return "createcategory"; //.html
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute Category category) {

        categoryRepository.save(category);
        
        return "redirect:categorylist";
    }
    

}
