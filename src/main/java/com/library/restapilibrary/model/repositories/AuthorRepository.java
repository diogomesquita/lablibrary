package com.library.restapilibrary.model.repositories;

import com.library.restapilibrary.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Boolean existsByName(String name);
}