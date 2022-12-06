package com.library.restapibookstore.model.repositories;

import com.library.restapibookstore.model.entities.Book;
import com.library.restapibookstore.model.entities.Client;
import com.library.restapibookstore.model.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    boolean existsByClientAndBook(Client c, Book b);
}
