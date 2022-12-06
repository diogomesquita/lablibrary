package com.library.restapilibrary.model.services;

import com.library.restapilibrary.exceptions.NotFoundExceptions;
import com.library.restapilibrary.model.entities.Author;
import com.library.restapilibrary.model.repositories.AuthorRepository;
import com.library.restapilibrary.model.services.interfaces.AuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAll(){
        List<Author> list = authorRepository.findAll();
        return list;
    }

    public Author find(Long id) {
        Optional<Author> getAuthor = authorRepository.findById(id);
        return  getAuthor.orElseThrow(() -> {
            return new NotFoundExceptions(id);
        });
    }

    public Author save(Author author) {

        if (authorRepository.existsByName(author.getName())){
            String message = String.format("Unavailable name. The product %s s already resgistered", author.getName());
            throw new DataIntegrityViolationException(message);
        }
        return authorRepository.save(author);
    }

    public void delete(Long id) {
        try {
            authorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundExceptions(e.getMessage());
        }
    }

    public Author update(Long id, Author author) {
        Author dbData = find(id);
        BeanUtils.copyProperties(author, dbData, "id");
        return authorRepository.save(dbData);
    }
}