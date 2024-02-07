package com.car.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.car.store.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	UserDetails findByLogin(String login);
		
	
}
