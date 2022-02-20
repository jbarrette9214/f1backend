package com.barrette.f1site.utilities;

import org.springframework.http.HttpStatus;

public class ErrorInfo {
	
	private HttpStatus status;
	private String errorMessage;
	
	public ErrorInfo() {}

	public ErrorInfo(HttpStatus status, String errorMessage) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorInfo [status=" + status + ", errorMessage=" + errorMessage + "]";
	}
	
	

}
