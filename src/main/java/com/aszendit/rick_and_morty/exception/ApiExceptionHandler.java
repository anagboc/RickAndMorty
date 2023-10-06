package com.aszendit.rick_and_morty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.aszendit.rick_and_morty.model.ErrorResponse;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RickAndMortyApiException.class)
    public ResponseEntity<ErrorResponse> handleRickAndMortyApiException(RickAndMortyApiException ex) {
		// Customize the error response 
        ErrorResponse errorResponse = new ErrorResponse("Rick and Morty Api Error: ", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
