package com.library.restapilibrary.exceptions;

public class DeadbeatExcepion extends RuntimeException{

    public DeadbeatExcepion(){
        super("tá sem saldo!");
    }
}