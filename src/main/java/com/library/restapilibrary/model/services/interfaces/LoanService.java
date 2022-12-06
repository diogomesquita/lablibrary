package com.library.restapibookstore.model.services.interfaces;

import com.library.restapibookstore.model.entities.Book;
import com.library.restapibookstore.model.entities.Client;
import com.library.restapibookstore.model.entities.Loan;

import java.util.List;

public interface LoanService {
    public List<Loan> getAll();

    public Loan find(Long id);

    public Loan save(Client client, Book book);

    public void delete(Long id);

    public Loan update(Long id, Loan loan);
}
