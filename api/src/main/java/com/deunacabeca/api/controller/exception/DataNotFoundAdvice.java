package com.deunacabeca.api.controller.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DataNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	Map<String, String> DataNotFoundHandler (DataNotFoundException ex) {
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", ex.getMessage());

		return response;
	}
}
