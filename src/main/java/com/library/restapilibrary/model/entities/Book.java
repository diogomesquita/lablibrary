package com.library.restapibookstore.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "tb_book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @Min(value = 1)
    private Integer quantity;
    @Min(value = 0)
    private Double price;

    @JsonIgnore
    @OneToOne(mappedBy = "book")
    private Loan loan;

    public Book(String title, Integer quantity, Double price, Author author) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }
}
