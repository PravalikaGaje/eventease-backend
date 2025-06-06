package com.eventmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BookingSaveFailException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public BookingSaveFailException(String message) {
		super(message);
	}

}
