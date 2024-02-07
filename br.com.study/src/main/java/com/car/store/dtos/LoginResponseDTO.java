package com.car.store.dtos;

public record LoginResponseDTO (String token){

	public LoginResponseDTO(String token) {
		this.token = token;
		
	}

}
