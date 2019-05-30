package com.deunacabeca.api.controller.exception;

public class SorteioNotFoundException extends RuntimeException {
	public SorteioNotFoundException(Long id) {
		super("Sorteio " + id + " não encontrado.");
	}
}
