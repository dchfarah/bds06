package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthService service;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getProfile() {
        com.devsuperior.movieflix.entities.User user = service.authenticated();
        return ResponseEntity.ok().body(new UserDTO(user));
    }
}
