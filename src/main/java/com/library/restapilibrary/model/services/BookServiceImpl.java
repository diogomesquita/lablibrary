package com.library.restapibookstore.model.services;

import com.library.restapibookstore.exceptions.NotFoundExceptions;
import com.library.restapibookstore.model.entities.Book;
import com.library.restapibookstore.model.repositories.BookRepository;
import com.library.restapibookstore.model.services.interfaces.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        List<Book> list = bookRepository.findAll();
        return list;
    }

    @Override
    public Book find(Long id) {
        Optional<Book> dbBook = bookRepository.findById(id);
        return dbBook.orElseThrow(() -> {
            return new NotFoundExceptions(id);
        });
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book update(Long id, Book book) {
        Book dbBook = find(id);
        BeanUtils.copyProperties(book, dbBook, "id");
        return dbBook;
    }
}
