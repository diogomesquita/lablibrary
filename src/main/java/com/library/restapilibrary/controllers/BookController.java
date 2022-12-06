package com.library.restapibookstore.controllers;

import com.library.restapibookstore.model.entities.Book;
import com.library.restapibookstore.model.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        List<Book> l = bookService.getAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }
}
