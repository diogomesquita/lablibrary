package com.library.restapibookstore.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorFormatter {

    private Instant timeStamp;
    private Integer status;
    private String message;
}
