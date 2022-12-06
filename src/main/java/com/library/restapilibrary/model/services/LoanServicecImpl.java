package com.library.restapibookstore.model.services;

import com.library.restapibookstore.exceptions.DeadbeatExcepion;
import com.library.restapibookstore.exceptions.NotFoundExceptions;
import com.library.restapibookstore.model.entities.Book;
import com.library.restapibookstore.model.entities.Client;
import com.library.restapibookstore.model.entities.Loan;
import com.library.restapibookstore.model.repositories.LoanRepository;
import com.library.restapibookstore.model.services.interfaces.LoanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServicecImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public List<Loan> getAll() {
        try {
            List<Loan> list = loanRepository.findAll();
            return list;
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundExceptions(e.getMessage());
        }
    }

    @Override
    public Loan find(Long id) {
        Optional<Loan> dbLoan = loanRepository.findById(id);
        return dbLoan.orElseThrow(() -> {
            throw  new NotFoundExceptions(id);
        });
    }

    @Override
    public Loan save(Client c, Book b) {
        if(loanRepository.existsByClientAndBook(c, b)) {
            throw new DataIntegrityViolationException("already loan ");
        } else  {
            if ((c.getBankCard().getBalance() + c.getBankCard().getAccountLimit()) >= b.getPrice()) {
                LocalDate starts = LocalDate.now();
                LocalDate ends = starts.plusDays(1);
                return loanRepository.save(new Loan(starts, ends, b.getPrice(), true, b, c));
            } else {
                throw new DeadbeatExcepion();
            }
        }
    }

    @Override
    public void delete(Long id) {
        loanRepository.deleteById(id);
    }

    @Override
    public Loan update(Long id, Loan loan) {
        Loan dbLoan = find(id);
        BeanUtils.copyProperties(loan, dbLoan, "id");
        return dbLoan;
    }
}
