package com.car.store.infra.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class MessageResponse {
	private HttpStatus status;
	private String content;
	private LocalDateTime timestamp;
	
	public MessageResponse (HttpStatus status, String content, LocalDateTime timestamp) {
		
		this.status = status;
		this.content = content;
		this.timestamp = timestamp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
