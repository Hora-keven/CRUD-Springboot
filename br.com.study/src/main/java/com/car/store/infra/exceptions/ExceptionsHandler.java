package com.car.store.infra.exceptions;


import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CarException.class)
	public ResponseEntity<MessageResponse> error404CarNotFound(CarException ex, WebRequest request){
		MessageResponse message = new MessageResponse(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(message, new HttpHeaders(), message.getStatus());
		
	}
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MessageResponse> error400UserAlreadyExists(UserException ex, WebRequest request){
		MessageResponse message = new MessageResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(message, new HttpHeaders(), message.getStatus());
		
	}
	
	@ExceptionHandler(TokenException.class)
	public ResponseEntity<MessageResponse> error401TokenInvalid(TokenException ex, WebRequest request){
		MessageResponse message = new MessageResponse(HttpStatus.UNAUTHORIZED, ex.getMessage(), LocalDateTime.now());
		// return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
		return new ResponseEntity<>(message, new HttpHeaders(), message.getStatus());
	
		
	}
	
	
	
}
