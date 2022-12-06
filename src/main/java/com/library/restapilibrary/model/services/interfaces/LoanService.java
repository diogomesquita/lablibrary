package com.library.restapilibrary.model.services.interfaces;

import com.library.restapilibrary.model.entities.Book;
import com.library.restapilibrary.model.entities.Client;
import com.library.restapilibrary.model.entities.Loan;

import java.util.List;

public interface LoanService {
    public List<Loan> getAll();

    public Loan find(Long id);

    public Loan save(Client client, Book book);

    public void delete(Long id);

    public Loan update(Long id, Loan loan);
}