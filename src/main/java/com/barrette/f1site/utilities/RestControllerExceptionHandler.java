package com.barrette.f1site.utilities;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

	@ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
	public ResponseEntity<ErrorInfo> handleValidationException(Exception exc) {
		String errorMsg;
		
		if(exc instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException exception = (MethodArgumentNotValidException) exc;
			errorMsg = exception.getBindingResult().getAllErrors().stream().map(x-> x.getDefaultMessage()).collect(Collectors.joining(", "));
		} else {
			ConstraintViolationException constraint = (ConstraintViolationException) exc;
			errorMsg = constraint.getConstraintViolations().stream().map(x-> x.getMessage()).collect(Collectors.joining(", "));
		}
		
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorMessage(errorMsg);
		errorInfo.setStatus(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
}
