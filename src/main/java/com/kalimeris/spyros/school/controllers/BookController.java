package com.kalimeris.spyros.school.controllers;

import com.kalimeris.spyros.school.repositories.AuthorRepository;
import com.kalimeris.spyros.school.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    // we need it cause its going to automatically inject to the constructor an instance of the bookRepository
    private BookRepository bookRepository;


    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        // books is the name that the view (Thymeleaf will have access to them) and it will be a list of books
        // from the bookRepository.findAll()
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

}
