package com.exerate.ui.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exerate.ui.model.response.ErrorMessage;

@ControllerAdvice
public class ResponseEntityException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		
		String errorMessageDescription= ex.getLocalizedMessage();
		
		if(errorMessageDescription==null) errorMessageDescription=ex.toString();
		
		ErrorMessage message = new ErrorMessage(new Date(), ex.getLocalizedMessage());
		
		return new ResponseEntity<>(message,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request){
		
		String errorMessageDescription= ex.getLocalizedMessage();
		
		if(errorMessageDescription==null) errorMessageDescription=ex.toString();
		
		ErrorMessage message = new ErrorMessage(new Date(), ex.getLocalizedMessage());
		
		return new ResponseEntity<>(message,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = {UserServiceException.class})
	public ResponseEntity<Object> handleNullPointerException(UserServiceException ex, WebRequest request){
		
		String errorMessageDescription= ex.getLocalizedMessage();
		
		if(errorMessageDescription==null) errorMessageDescription=ex.toString();
		
		ErrorMessage message = new ErrorMessage(new Date(), ex.getLocalizedMessage());
		
		return new ResponseEntity<>(message,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
