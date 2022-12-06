package com.library.restapilibrary.model.entities;

import com.library.restapilibrary.model.entities.enums.CardType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "tb_bankcard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankCard implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cardNumber;
    private Double accountLimit = 100.00;
    @Min(value = 0)
    private Double balance;
    private CardType cardType;

    @JsonIgnore
    @OneToOne(mappedBy = "bankCard")
    private Client client;

    public BankCard(String cardNumber, Double accountLimit, Double balance, CardType cardType) {
        this.cardNumber = cardNumber;
        this.accountLimit = accountLimit;
        this.balance = balance;
        this.cardType = cardType;
    }
}