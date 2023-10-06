package com.aszendit.rick_and_morty.exception;

public class RickAndMortyApiException extends RuntimeException {
	
	public RickAndMortyApiException() {
        super();
    }

    public RickAndMortyApiException(String message) {
        super(message);
    }

    public RickAndMortyApiException(String message, Throwable cause) {
        super(message, cause);
    }

}
