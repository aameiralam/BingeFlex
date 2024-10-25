package com.finalProject.service;

import com.finalProject.dto.AuthRequest;
import com.finalProject.dto.PostNewUser;

public interface UserCredentialService {

    void createUser(PostNewUser postNewUser);

    String login (AuthRequest authRequest);
}
