package learn.springboot.simplewebapplication.repositories;

import learn.springboot.simplewebapplication.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
