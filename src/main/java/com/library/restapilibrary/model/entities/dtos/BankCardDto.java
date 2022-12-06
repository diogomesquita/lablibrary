package com.library.restapibookstore.model.entities.dtos;

import com.library.restapibookstore.model.entities.Client;
import com.library.restapibookstore.model.entities.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankCardDto {

    private Client client;
    @NotNull
    private Double balance;
    @NotNull
    private CardType cardType;
}
