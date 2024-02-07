package com.car.store.dtos;

import com.car.store.model.User;
import com.car.store.model.UserRole;

public record UserResponse(long id, String login, UserRole role) {
	
	public UserResponse(User user) {
		this(user.getId(), user.getLogin(), user.getRole());
	}

}
