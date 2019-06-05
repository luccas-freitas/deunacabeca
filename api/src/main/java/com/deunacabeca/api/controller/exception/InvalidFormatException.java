package com.deunacabeca.api.controller.exception;

import java.text.ParseException;

public class InvalidFormatException extends ParseException {
	private static final long serialVersionUID = -1331896664752522914L;

	public InvalidFormatException(String message) {
		super(message, 0);
	}
}
