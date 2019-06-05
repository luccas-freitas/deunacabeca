package com.deunacabeca.api.controller.exception;

public class NumberConvertException extends NumberFormatException {
    private static final long serialVersionUID = 1L;

    public NumberConvertException(String message) {
		super(message);
	}
}