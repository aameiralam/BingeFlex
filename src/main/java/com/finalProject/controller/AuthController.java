package com.finalProject.controller;

import com.finalProject.dto.AuthRequest;
import com.finalProject.dto.PostNewUser;
import com.finalProject.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private UserCredentialService userCredentialService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(userCredentialService.login(authRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<?> postNewUser(@RequestBody PostNewUser postNewUser){
        userCredentialService.createUser(postNewUser);
        return ResponseEntity.ok().build();
    }
}
