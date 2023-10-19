package learn.springboot.simplewebapplication.bootstrap;

import learn.springboot.simplewebapplication.model.Author;
import learn.springboot.simplewebapplication.model.Book;
import learn.springboot.simplewebapplication.model.Publisher;
import learn.springboot.simplewebapplication.repositories.AuthorRepository;
import learn.springboot.simplewebapplication.repositories.BookRepository;
import learn.springboot.simplewebapplication.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in BootStrap...");

        Publisher publisher = new Publisher();
        publisher.setPubName("Mustermann");
        publisher.setAdressLine1("Musterstr. 111");
        publisher.setCity("Bremen");
        publisher.setZip("29191");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "11255585588");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "7888373636");

        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        publisherRepository.save(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        System.out.println("Number of the Books: " + bookRepository.count());
        System.out.println("Number of Author: " + authorRepository.count());
        System.out.println("Publisher Numaber of Books: " + publisher.getBooks().size());

    }
}
