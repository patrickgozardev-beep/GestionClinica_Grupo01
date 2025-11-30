package com.clinica.dto;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String password
) {}