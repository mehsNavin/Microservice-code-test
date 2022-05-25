package com.shopping.exception.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

	@JsonProperty("error")
	private String error;
	@JsonProperty("message")
	private String message;
	
	public ErrorResponse(String error, String message) {
		super();
		this.error = error;
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
