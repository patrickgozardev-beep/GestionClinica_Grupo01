package com.clinica.demo;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    public static void main(String[] args) {
        // Contraseña que quieres hashear para pruebas
        String passwordPlano = "clinica123";

        // Instancia del codificador (¡debe ser la misma usada en SecurityConfig!)
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Generar el hash
        String hashedPassword = encoder.encode(passwordPlano);

        System.out.println("--- GENERADOR DE HASH BCrypt ---");
        System.out.println("Contraseña Plana: " + passwordPlano);
        System.out.println("Hash Generado: " + hashedPassword);
        System.out.println("---------------------------------");
        System.out.println("COPIA ESTE HASH Y PEGALO EN TU TABLA USUARIOS.");

        // Puedes probar si coincide (solo para verificar)
        boolean matches = encoder.matches(passwordPlano, hashedPassword);
        System.out.println("Verificación (Debe ser true): " + matches);
    }
}
