package com.deunacabeca.api.controller.exception;

import java.text.ParseException;

public class DataNotFoundException extends ParseException {
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String data) {
		super("Formato de data '" + data + "' inválida.", 0);
	}
}
