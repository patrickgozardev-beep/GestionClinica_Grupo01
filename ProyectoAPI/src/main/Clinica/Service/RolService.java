package com.clinica.service;

import com.clinica.model.Rol;
import com.clinica.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerRol(Integer id) {
        return rolRepository.findById(id);
    }

    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol actualizarRol(Integer id, Rol rol) {
        rol.setRolId(id);
        return rolRepository.save(rol);
    }

    public void eliminarRol(Integer id) {
        rolRepository.deleteById(id);
    }
}