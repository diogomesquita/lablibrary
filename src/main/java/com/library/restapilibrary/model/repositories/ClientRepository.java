package com.library.restapibookstore.model.repositories;

import com.library.restapibookstore.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Boolean existsByName(String name);
}
