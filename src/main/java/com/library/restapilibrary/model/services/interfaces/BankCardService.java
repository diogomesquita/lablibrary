package com.library.restapibookstore.model.services.interfaces;


import com.library.restapibookstore.model.entities.BankCard;

import java.util.List;

public interface BankCardService {

    public List<BankCard> getAll();

    public BankCard getBalance(BankCard bc);

    public BankCard save(BankCard bankCard);

    public void delete(Long id);
}
