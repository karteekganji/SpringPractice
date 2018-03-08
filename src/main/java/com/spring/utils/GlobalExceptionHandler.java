package com.spring.utils;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(value = IllegalArgumentException.class)
	public GeneralResponse handleIllegalArgumentException(final IllegalArgumentException e) {
		final String errorMessage = e.getMessage();
		logger.error("error in handleIllegalArgumentException :: " + errorMessage);
		e.printStackTrace();
		return new GeneralResponse(Constants.RESPONSE_FAILURE, errorMessage);
	}
	
}
