package com.kalimeris.spyros.school.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    // an author cannot write the exact same book twice, so we use a set
    // also we don't get about the order of the items

    // we need to declare the relationship - basic type should not be a container
    @ManyToMany(mappedBy = "authors")
    // Cannot invoke "java.util.List.add(Object)" because the return value
    // of "com.kalimeris.spyros.school.entities.Author.getBooks()" is null
    private List<Book> books  = new ArrayList<>();

    public Author(){}

    public Author(String firstName, String lastname){
        this.firstName = firstName;
        this.lastName = lastname;
    }

    public Author(String firstName, String lastName, List<Book> books){
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
