package com.car.store.dtos;

import com.car.store.model.UserRole;

public record RegisterDto(String login, String password, UserRole role) {
	

}
