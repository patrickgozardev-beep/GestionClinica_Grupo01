package com.clinica.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_TEXT = "UnaCadenaLargaYTotalmenteAleatoriaQueNadiePuedaAdivinar_5r7tY9uI0p1Q2w3E4r5T6y7U8i9O0P_";
    private final String SECRET = Base64.getEncoder().encodeToString(SECRET_TEXT.getBytes());

    public String generateToken(String email) {
        // ... (Tu código actual para generar el token) ...
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    // --- NUEVOS MÉTODOS ---

    // Método para obtener el email (subject) del token
    public String getEmailFromJwt(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Método para validar la firma y la fecha de expiración del token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            // Logear o manejar token con firma inválida
        } catch (MalformedJwtException ex) {
            // Logear o manejar token malformado
        } catch (ExpiredJwtException ex) {
            // Logear o manejar token expirado
        } catch (UnsupportedJwtException ex) {
            // Logear o manejar token no soportado
        } catch (IllegalArgumentException ex) {
            // Logear o manejar cadena de JWT vacía o nula
        }
        return false;
    }
}