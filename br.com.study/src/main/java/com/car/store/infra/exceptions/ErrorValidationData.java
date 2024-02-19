package com.car.store.infra.exceptions;

import org.springframework.validation.FieldError;

public record ErrorValidationData(String field, String message) {
	public ErrorValidationData(FieldError error) {
		this(error.getField(), error.getDefaultMessage());
	}
}
