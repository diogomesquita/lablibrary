package com.library.restapibookstore.model.repositories;

import com.library.restapibookstore.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Boolean existsByTitle(String name);
}
