package com.library.restapilibrary.model.entities.dtos;

import com.library.restapilibrary.model.entities.Book;
import com.library.restapilibrary.model.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    @NotNull
    private Book book;
    @NotNull
    private Client client;
    @NotNull
    private Boolean status;
}