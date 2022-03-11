package com.company.GutenbergAPI.controller;

import com.company.GutenbergAPI.model.Book;
import com.company.GutenbergAPI.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RefreshScope
public class GutenbergController {

    @Autowired
    BooksRepository booksRepository;

    @GetMapping("/search")
    public List<Book> getAllBooks() {
        List<Book> allBooks = booksRepository.findAll();
        return allBooks;
    }

    @GetMapping("/search/{query}")
    public List<Book> getBooksFromQuery(@PathVariable String query) {

        //  Get all the books
        List<Book> allBooks = booksRepository.findAll();

        if(query.equals("")) {
            return allBooks;
        }

        //  Filter out the books
        List<Book> foundBooks = allBooks
                .stream()
                .filter(b -> b.getTitle().contains(query))
                .collect(Collectors.toList());

        return foundBooks;
    }
}
