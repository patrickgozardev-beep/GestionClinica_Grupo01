package com.clinica.service.impl;

import com.clinica.config.SecurityConfig;
import com.clinica.dto.RegisterRequest;
import com.clinica.model.Rol;
import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;
import com.clinica.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder; // 1. Nuevo campo para la inyección

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder; // Se asigna el Bean
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + id));
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Usuario no encontrado: " + id);
        }
        repository.deleteById(id);
    }

    public Usuario registerNewUser(RegisterRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new RuntimeException("El correo electrónico ya está registrado.");
        }

        Usuario newUser = new Usuario();
        newUser.setEmail(request.email());
        newUser.setNombre(request.firstName());
        newUser.setApellidos(request.lastName());
        newUser.setEmail(request.email());
        newUser.setTelefono(request.phoneNumber());
        newUser.setPasswordHash(passwordEncoder.encode(request.password()));

        Rol rol = new Rol();
        rol.setId(3);

        newUser.setRol(rol);

        return repository.save(newUser);
    }
}
