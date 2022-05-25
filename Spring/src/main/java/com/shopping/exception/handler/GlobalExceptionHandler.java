package com.shopping.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value=InactiveProduct.class)
	public ResponseEntity<Object> InactivehandleError(Exception exception, WebRequest input){
		return handleExceptionInternal(exception, new ErrorResponse("Internal Server Error",exception.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, input);
	}
	
	@ExceptionHandler(value=TransactionCostExceeded.class)
	public ResponseEntity<Object> CostExceededhandleError(Exception exception, WebRequest input){
		return handleExceptionInternal(exception, new ErrorResponse("Internal Server Error",exception.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, input);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		
		return handleExceptionInternal(ex, new ErrorResponse("Internal Server Error",ex.getBindingResult().getFieldError().getDefaultMessage()), 
				headers, status, request);

	}
}
