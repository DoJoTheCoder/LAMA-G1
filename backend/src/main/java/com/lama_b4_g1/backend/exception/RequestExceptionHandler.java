package com.lama_b4_g1.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RequestExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public @ResponseBody ExceptionDetails handleResourceNotFoundException(ResourceNotFoundException e) {
		return new ExceptionDetails(e.getMessage(), HttpStatus.NOT_FOUND.value());
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = DataNotFoundException.class)
	public @ResponseBody ExceptionDetails handleDataNotFoundException(DataNotFoundException e) {
		return new ExceptionDetails(e.getMessage(), HttpStatus.NOT_FOUND.value());
	}
}
