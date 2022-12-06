package com.library.restapilibrary.model.entities.dtos;

import com.library.restapilibrary.model.entities.BankCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    private BankCard bankCard;
}