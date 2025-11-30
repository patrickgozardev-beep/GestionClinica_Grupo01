package com.clinica.service;

import java.util.List;

import com.clinica.dto.RegisterRequest;
import com.clinica.model.Usuario;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    void delete(Long id);
    Usuario registerNewUser(RegisterRequest request);

}
