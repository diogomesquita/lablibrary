package com.library.restapibookstore.model.repositories;

import com.library.restapibookstore.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Boolean existsByName(String name);
}
