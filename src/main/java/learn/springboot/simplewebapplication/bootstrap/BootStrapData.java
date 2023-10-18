package learn.springboot.simplewebapplication.bootstrap;

import learn.springboot.simplewebapplication.model.Author;
import learn.springboot.simplewebapplication.model.Book;
import learn.springboot.simplewebapplication.repositories.AuthorRepository;
import learn.springboot.simplewebapplication.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "11255585588");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "7888373636");

        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in BootStrap...");
        System.out.println("Number of the Books: " + bookRepository.count());

    }
}
