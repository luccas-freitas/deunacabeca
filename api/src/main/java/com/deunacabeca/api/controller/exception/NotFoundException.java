package com.deunacabeca.api.controller.exception;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7357856247386553042L;

	public NotFoundException(String message) {
		super(message);
	}
}
