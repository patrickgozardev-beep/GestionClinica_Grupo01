package com.clinica.service.impl;

import com.clinica.model.Rol;
import com.clinica.repository.RolRepository;
import com.clinica.service.RolService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository repository;

    @Override
    public List<Rol> findAll() {
        return repository.findAll();
    }

    @Override
    public Rol findById(Short id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado: " + id));
    }

    @Override
    public Rol save(Rol rol) {
        return repository.save(rol);
    }

    @Override
    public void delete(Short id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Rol no encontrado: " + id);
        }
        repository.deleteById(id);
    }
}
