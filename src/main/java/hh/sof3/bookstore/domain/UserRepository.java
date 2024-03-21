package hh.sof3.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    List<User> findById(long id);
}
