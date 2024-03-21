package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof3.bookstore.domain.User;
import hh.sof3.bookstore.domain.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void userExists() {
        User user = userRepository.findByUsername("someOtherUser");
        // Miksei "List<User> users" toimi?

        assertThat(user).isNotNull();
        
    }

    @Test
    void createUser() {
        User user = new User("newUser", "$2a$10$KtjeOxsgnu.zHX7vlP3xFOJe8qLGmBsl7P0ZU1b0iC84St8rBOYxu", "user");
        // usersTestPw

        userRepository.save(user);

        assertThat(user.getId()).isNotNull();
    }


}
