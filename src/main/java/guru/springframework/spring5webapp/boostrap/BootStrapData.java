package guru.springframework.spring5webapp.boostrap;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.domain.author;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import guru.springframework.spring5webapp.repositories.authorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final authorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publicRepository;

    public BootStrapData(guru.springframework.spring5webapp.repositories.authorRepository authorRepository, BookRepository bookRepository, PublisherRepository publicRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publicRepository = publicRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Boostrap");
        Publisher publisher = new Publisher ();
        publisher.setName("Max");
        publisher.setCity("New York City");
        publisher.setState("NY");

        publicRepository.save(publisher);

        System.out.println("Publisher Count: "+publicRepository.count());

        author eric = new author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publicRepository.save(publisher);


        author rod = new author ("Rod", "Johnson");
        Book noEJB = new Book ("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publicRepository.save(publisher);

        System.out.println("Number of Books "+bookRepository.count());
        System.out.println("Publisher Number of Books: "+publisher.getBooks().size());
    }
}