package com.excalibur.spring6webapp.bootstrap;

import com.excalibur.spring6webapp.domain.Author;
import com.excalibur.spring6webapp.domain.Book;
import com.excalibur.spring6webapp.domain.Publisher;
import com.excalibur.spring6webapp.repositories.AuthorRepository;
import com.excalibur.spring6webapp.repositories.BookRepository;
import com.excalibur.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author alexia = new Author();
        alexia.setFirstName("Alexia");
        alexia.setLastName("Straza");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author alexiaSaved = authorRepository.save(alexia);
        Book dddSaved = bookRepository.save(ddd);

        Author sylnas = new Author();
        sylnas.setFirstName("Sylnas");
        sylnas.setLastName("Storm");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author sylnasSaved = authorRepository.save(sylnas);
        Book noEJBSaved = bookRepository.save(noEJB);

        alexiaSaved.getBooks().add(dddSaved);
        sylnasSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(alexiaSaved);
        noEJBSaved.getAuthors().add(sylnasSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        noEJBSaved.setPublisher(savedPublisher);

        authorRepository.save(alexiaSaved);
        authorRepository.save(sylnasSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());

        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}