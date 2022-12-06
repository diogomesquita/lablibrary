package com.library.restapilibrary.model.services.interfaces;

import com.library.restapilibrary.model.entities.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAll();

    public Book find(Long id);

    public Book save(Book book);

    public void delete(Long id);

    public Book update(Long id, Book book);
}