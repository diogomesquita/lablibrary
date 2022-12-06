package com.library.restapilibrary.model.repositories;

import com.library.restapilibrary.model.entities.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Long> {
    BankCard existsByClientName(String name);
}