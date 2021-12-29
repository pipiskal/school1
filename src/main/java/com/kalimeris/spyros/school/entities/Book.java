package com.kalimeris.spyros.school.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String isbn;
    @OneToOne
    private Publisher publisher;


    // because by default it creates 2 tables to define the many to many relationship we want to have only one
    // @JoinColumns helps as to define a name for the id of the books called book_id in ou case
    // inverseJoinColumns helps to refine the reverse Relationship from class Author
    @ManyToMany
    // We define exactly how the table is going to look like
    @JoinTable(name = "author_book", //how the table will be called
            joinColumns = @JoinColumn(name = "book_id"),  // we are at the book class, so we join the id with name book_id
            inverseJoinColumns = @JoinColumn(name = "author_id") // and we need the inverse join from Author class
    )
    private List<Author> authors = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book(){}

    public Book(String title, String isbn, Publisher publisher){
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Book(String title, String isbn, Publisher publisher, List<Author> authors){
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}

