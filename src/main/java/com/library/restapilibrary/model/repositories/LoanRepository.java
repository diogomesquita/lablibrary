package com.library.restapilibrary.model.repositories;

import com.library.restapilibrary.model.entities.Book;
import com.library.restapilibrary.model.entities.Client;
import com.library.restapilibrary.model.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    boolean existsByClientAndBook(Client c, Book b);
}