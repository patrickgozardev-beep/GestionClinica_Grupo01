package com.clinica.service.impl;

import com.clinica.model.Especialidad;
import com.clinica.repository.EspecialidadRepository;
import com.clinica.service.EspecialidadService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository repository;

    @Override
    public List<Especialidad> findAll() {
        return repository.findAll();
    }

    @Override
    public Especialidad findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Especialidad no encontrada: " + id));
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        return repository.save(especialidad);
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Especialidad no encontrada: " + id);
        }
        repository.deleteById(id);
    }
}
