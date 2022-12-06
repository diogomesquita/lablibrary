package com.library.restapibookstore.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
//    @CPF
//    @Column(unique = true)
    private String cpf;

    @OneToOne
    @JoinColumn(name = "bankcard_id")
    private BankCard bankCard;

    @JsonIgnore
    @OneToOne(mappedBy = "client")
    private Loan loan;

    public Client(String name, String cpf, BankCard bankCard) {
        this.name = name;
        this.cpf = cpf;
        this.bankCard = bankCard;
    }
}
