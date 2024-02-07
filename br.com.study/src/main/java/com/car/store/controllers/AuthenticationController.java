package com.car.store.controllers;


import com.car.store.dtos.UserResponse;
import com.car.store.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.car.store.dtos.AuthenticationDto;
import com.car.store.dtos.LoginResponseDTO;
import com.car.store.dtos.RegisterDto;
import com.car.store.infra.security.TokenService;
import com.car.store.repositories.UserRepository;
import com.car.store.services.UserService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private UserService userServices;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository repository;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDto data){

        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDTO(tokenService.login(data)));
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto data){


        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(tokenService.register(data)));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(userServices.findAll());
    }
}


