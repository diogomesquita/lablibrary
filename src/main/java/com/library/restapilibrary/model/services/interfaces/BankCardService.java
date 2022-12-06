package com.library.restapilibrary.model.services.interfaces;


import com.library.restapilibrary.model.entities.BankCard;

import java.util.List;

public interface BankCardService {

    public List<BankCard> getAll();

    public BankCard getBalance(BankCard bc);

    public BankCard save(BankCard bankCard);

    public void delete(Long id);
}