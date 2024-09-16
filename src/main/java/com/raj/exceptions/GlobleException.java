package com.raj.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobleException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResourceNotFoundException> ResourceNFE(Exception e) {
		String message = e.getMessage();
		ResourceNotFoundException notFoundException = new ResourceNotFoundException(message);
		return new ResponseEntity<ResourceNotFoundException>(notFoundException, HttpStatus.NOT_IMPLEMENTED);
	}

}
