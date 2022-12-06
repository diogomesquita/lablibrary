package com.library.restapibookstore.model.services;

import com.library.restapibookstore.exceptions.NotFoundExceptions;
import com.library.restapibookstore.model.entities.BankCard;
import com.library.restapibookstore.model.repositories.BankCardRepository;
import com.library.restapibookstore.model.services.interfaces.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankCardServiceImpl implements BankCardService {
    @Autowired
    private BankCardRepository bankCardRepository;

    @Override
    public List<BankCard> getAll() {
        try {
            List<BankCard> list = bankCardRepository.findAll();
            return list;
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundExceptions(e);
        }
    }

    @Override
    public BankCard getBalance(BankCard bc) {
        if((bankCardRepository.existsByClientName(bc.getClient().getName())) != null) {
           BankCard card = bankCardRepository.existsByClientName(bc.getClient().getName());
            return card;
        } else {
            throw new NotFoundExceptions(bc);
        }
    }

    @Override
    public BankCard save(BankCard bankCard) {
        return bankCardRepository.save(bankCard);
    }

    @Override
    public void delete(Long id) {
        bankCardRepository.deleteById(id);
    }
}
