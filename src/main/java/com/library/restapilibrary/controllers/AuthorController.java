package com.library.restapibookstore.controllers;

import com.library.restapibookstore.model.entities.Author;
import com.library.restapibookstore.model.entities.dtos.AuthorDto;
import com.library.restapibookstore.model.services.interfaces.AuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAll(){
       List<Author> list = authorService.getAll();
       return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> find(@PathVariable Long id) {
        Author author = authorService.find(id);
        return new ResponseEntity<>(author,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody @Valid AuthorDto authorDto) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDto, author);
        author = authorService.save(author);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> upadte(@PathVariable Long id, @RequestBody @Valid AuthorDto authorDto) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDto,author);
        author = authorService.update(id, author);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
