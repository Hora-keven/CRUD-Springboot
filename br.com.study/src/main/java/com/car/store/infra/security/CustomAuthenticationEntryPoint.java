package com.car.store.infra.security;

import java.io.IOException;
import java.io.PrintWriter;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.car.store.infra.exceptions.MessageResponse;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint{
	
	private Gson gson = new Gson();

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
			
			String responseError = this.gson.toJson("Unathorized");
			PrintWriter out = response.getWriter();
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			out.print(responseError);
			out.flush();
		
	}

}
