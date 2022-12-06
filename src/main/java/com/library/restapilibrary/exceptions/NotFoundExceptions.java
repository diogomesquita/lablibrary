package com.library.restapilibrary.exceptions;

public class NotFoundExceptions extends RuntimeException{

    public NotFoundExceptions(Object obj){
        super(String.format("404 Not Found - id: " + obj ));
    }
}