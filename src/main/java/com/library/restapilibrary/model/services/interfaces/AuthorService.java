package com.library.restapilibrary.model.services.interfaces;

import com.library.restapilibrary.model.entities.Author;

import java.util.List;
public interface AuthorService {

    public List<Author> getAll();

    public Author find(Long id);

    public Author save(Author author);

    public void delete(Long id);

    public Author update(Long id, Author author);
}