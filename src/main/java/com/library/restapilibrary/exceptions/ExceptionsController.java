package com.library.restapibookstore.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionsController {

    @ResponseBody
    @ExceptionHandler(NotFoundExceptions.class)
    public ResponseEntity<ErrorFormatter> notFoundExeptions(NotFoundExceptions e) {
        var msg = new ErrorFormatter(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorFormatter> dataIntegrityViolationException(DataIntegrityViolationException e) {
        var msg = new ErrorFormatter(Instant.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorFormatter> validationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        var message = new ErrorFormatter(Instant.now(), HttpStatus.BAD_REQUEST.value(), String.format("Missing Required Data: " + errors));
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
