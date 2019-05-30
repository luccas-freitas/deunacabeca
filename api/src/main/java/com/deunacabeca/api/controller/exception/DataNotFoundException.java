package com.deunacabeca.api.controller.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String data) {
        super("Não há lançamentos para o dia " + data + ".");
    }
}
