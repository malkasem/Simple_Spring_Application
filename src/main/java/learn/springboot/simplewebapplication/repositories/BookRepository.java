package learn.springboot.simplewebapplication.repositories;

import learn.springboot.simplewebapplication.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
