package com.deunacabeca.api.controller.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class Advice {
	@ResponseBody
	@ExceptionHandler(InvalidFormatException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	Map<String, String> invalidFormatHandler (InvalidFormatException ex) {
		Map<String, String> response = new HashMap<>();
		response.put("message", ex.getMessage());

		return response;
	}

	@ResponseBody
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	Map<String, String> numberFormatHandler (NumberFormatException ex) {
		Map<String, String> response = new HashMap<>();
		response.put("message", ex.getMessage());
		return response;
	}

	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	Map<String, String> sorteioNotFoundHandler (NotFoundException ex) {
		Map<String, String> response = new HashMap<>();
		response.put("message", ex.getMessage());
		return response;
	}
}
