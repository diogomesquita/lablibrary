package com.library.restapilibrary.model.entities.dtos;

import com.library.restapilibrary.model.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    @NotNull
    private String title;
    private Author author;
    @NotNull
    private Double price;
    @NotNull
    private Integer quantity;
}