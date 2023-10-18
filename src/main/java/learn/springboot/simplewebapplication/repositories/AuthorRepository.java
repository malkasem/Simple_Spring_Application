package learn.springboot.simplewebapplication.repositories;

import learn.springboot.simplewebapplication.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
