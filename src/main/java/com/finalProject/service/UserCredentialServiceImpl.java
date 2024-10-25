package com.finalProject.service;

import com.finalProject.config.JwtService;
import com.finalProject.dto.AuthRequest;
import com.finalProject.dto.PostNewUser;
import com.finalProject.entity.UserCredential;
import com.finalProject.repository.UserCredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialServiceImpl implements UserCredentialService{

    @Autowired
    private UserCredentialRepo userCredentialRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public void createUser(PostNewUser postNewUser) {

        UserCredential userCredential = new UserCredential();
        userCredential.setEmail(postNewUser.email());
        userCredential.setPassword(passwordEncoder.encode(postNewUser.password()));
        userCredential.setRoles(postNewUser.role());
        userCredentialRepo.save(userCredential);

    }

    @Override
    public String login(AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authRequest.email(),
                authRequest.password()
        );

        authenticationManager.authenticate(authenticationToken);
        String jwt = jwtService.generateToken(authRequest.email());
        return jwt;
    }
}
