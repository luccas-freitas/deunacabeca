package com.deunacabeca.api.controller.exception;

public class SorteioNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SorteioNotFoundException(Long id) {
		super("Sorteio " + id + " não encontrado.");
	}
}
