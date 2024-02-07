package com.car.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


import com.car.store.model.User;
import com.car.store.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	
	@Autowired
	 UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return repository.findByLogin(username);
	}
	
	public List<User> findAll(){
		List<User>users = repository.findAll();
		return users;
	}

	
	

}
