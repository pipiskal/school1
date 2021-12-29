package com.kalimeris.spyros.school.controllers;

import com.kalimeris.spyros.school.repositories.AuthorRepository;
import com.kalimeris.spyros.school.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    // if we dont pass the constructor it have a runTimeError
    // Cannot invoke "com.kalimeris.spyros.school.repositories.AuthorRepository.findAll()"
    // because "this.authorRepository" is null --> meaning that when running the getAuthors method
    // authorRepository has nothing to find cause its empty it was never innitilized with something
    // so we need the constuctor to automatically innitialize with the repositories
    public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    // Model is a data object that contains the information that is going to be served to the view
    // so, we pass it as a parameter to the function and load it with information that we want to pass
    // to the view so, we can have access with thymeleaf
    @RequestMapping("/authors")
    public  String getAuthors(Model model){
        // findAll() returns an iterable
        Iterable authors = authorRepository.findAll();
        model.addAttribute("authors",authors);
        return "index";

    }
    // at this mapping we pass both authors and books
    @RequestMapping("/authorsAndBooks")
    public String getAuthorsAndBooks(Model model){
        Iterable authors = authorRepository.findAll();
        Iterable books = bookRepository.findAll();
        model.addAttribute("authors", authors);
        model.addAttribute("books", books);

        return "index";
    }
}
