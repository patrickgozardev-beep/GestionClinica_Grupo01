package com.clinica.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class LoginResponseDto {

    private String token;
    private String role;

    public LoginResponseDto(String token, UserDetails userDetails) {
        this.token = token;

        Optional<String> authority = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst();

        String fullRoleName = authority.orElse("ROLE_PACIENTE");

        if (fullRoleName.startsWith("ROLE_")) {
            this.role = fullRoleName.substring(5).toLowerCase();
        } else {
            // Si no tiene prefijo, solo convierte a minúsculas
            this.role = fullRoleName.toLowerCase();
        }
    }

    // Getters y Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}