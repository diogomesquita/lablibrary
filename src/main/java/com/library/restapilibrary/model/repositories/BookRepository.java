package com.library.restapilibrary.model.repositories;

import com.library.restapilibrary.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Boolean existsByTitle(String name);
}