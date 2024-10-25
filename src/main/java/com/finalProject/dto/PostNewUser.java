package com.finalProject.dto;

public record PostNewUser(
        String email,
        String password,
        String role
) {
}
