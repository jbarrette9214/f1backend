package com.barrette.f1site.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {

	@Autowired
	Environment env;
	
	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<ErrorInfo> handleGeneralException(GeneralException exc) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(env.getProperty(exc.getMessage()));
		error.setStatus(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
