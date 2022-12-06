package com.library.restapibookstore.exceptions;

public class DeadbeatExcepion extends RuntimeException{

    public DeadbeatExcepion(){
        super("tá sem saldo!");
    }
}
