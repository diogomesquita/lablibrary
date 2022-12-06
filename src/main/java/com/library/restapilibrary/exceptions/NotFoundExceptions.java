package com.library.restapibookstore.exceptions;

public class NotFoundExceptions extends RuntimeException{

    public NotFoundExceptions(Object obj){
        super(String.format("404 Not Found - id: " + obj ));
    }
}
