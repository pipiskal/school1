package com.kalimeris.spyros.school.bootstrapDB;

import com.kalimeris.spyros.school.entities.Author;
import com.kalimeris.spyros.school.entities.Book;
import com.kalimeris.spyros.school.entities.Publisher;
import com.kalimeris.spyros.school.repositories.AuthorRepository;
import com.kalimeris.spyros.school.repositories.BookRepository;
import com.kalimeris.spyros.school.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

// it will start when the applications runs
@Component // makes this a spring Bean
public class InnitializeDb implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public InnitializeDb(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    // on start up it will run this event
    // and run the method initData()
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
    // a method that creates 4 objects 2 books and 2 authors
    private void initData(){
        Author eric = new Author("Eric", "Evans");
        Publisher publisher1 = new Publisher("Pipis Kal", "Merkovouni Tripoli");
        publisherRepository.save(publisher1);
        Book harryPotter = new Book("Harry Potter", "1234", publisher1);
        // we add to our Map the new book that we created
        eric.getBooks().add(harryPotter);
        harryPotter.setPublisher(publisher1);

        authorRepository.save(eric);
        bookRepository.save(harryPotter);


        // Rod
        Author rod = new Author("Rod", "Mario");
        Book eragon = new Book("Eragon", "12345", publisher1);
        rod.getBooks().add(eragon);
        eragon.setPublisher(publisher1);

        authorRepository.save(rod);
        bookRepository.save(eragon);
    }




}
