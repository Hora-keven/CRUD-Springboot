package com.car.store.infra.exceptions;


import java.security.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
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
	public ResponseEntity<MessageResponse> error404UserAlreadyExists(UserException ex, WebRequest request){
		MessageResponse message = new MessageResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(message, new HttpHeaders(), message.getStatus());
		
	}
}
