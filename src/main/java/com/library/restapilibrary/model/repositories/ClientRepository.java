package com.library.restapilibrary.model.repositories;

import com.library.restapilibrary.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Boolean existsByName(String name);
}