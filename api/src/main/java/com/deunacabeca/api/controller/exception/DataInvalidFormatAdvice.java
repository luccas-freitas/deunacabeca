package com.deunacabeca.api.controller.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DataInvalidFormatAdvice {
	@ResponseBody
	@ExceptionHandler(DataInvalidFormatException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	Map<String, String> DataInvalidFormatHandler (DataInvalidFormatException ex) {
		Map<String, String> response = new HashMap<>();
		response.put("message", ex.getMessage());

		return response;
	}
}
