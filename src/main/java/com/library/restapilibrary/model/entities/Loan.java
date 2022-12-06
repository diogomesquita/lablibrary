package com.library.restapilibrary.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_loan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    @Min(value = 0)
    private Double cost;
    private Boolean status;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Loan(LocalDate startDate, LocalDate endDate, Double cost, Boolean status, Book book, Client client) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
        this.status = status;
        this.book = book;
        this.client = client;
    }
}