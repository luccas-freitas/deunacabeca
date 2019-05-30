package com.deunacabeca.api.controller.exception;

import java.text.ParseException;

public class DataInvalidFormatException extends ParseException {
	public DataInvalidFormatException(String data) {
		super("Formato de data '" + data + "' inválida.", 0);
	}
}
