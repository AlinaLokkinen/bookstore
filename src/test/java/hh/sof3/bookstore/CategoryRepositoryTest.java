package hh.sof3.bookstore;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void findByNameReturnCategory() {
        List<Category> categories = categoryRepository.findByName("horror");

        assertThat(categories).hasSizeGreaterThan(0);
    }

    @Test
    void createNewCategory() {
        Category category = new Category(4, "catName");
        categoryRepository.save(category);

        assertThat(category.getCategoryId()).isNotNull();
    }

    



}
