package com.library.restapilibrary.model.entities.dtos;

import com.library.restapilibrary.model.entities.Client;
import com.library.restapilibrary.model.entities.enums.CardType;
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