package com.library.restapibookstore.model.repositories;

import com.library.restapibookstore.model.entities.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Long> {
    BankCard existsByClientName(String name);
}
