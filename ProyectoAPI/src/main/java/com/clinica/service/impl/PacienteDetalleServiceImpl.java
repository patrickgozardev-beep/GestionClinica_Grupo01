package com.clinica.service.impl;

import com.clinica.model.PacienteDetalle;
import com.clinica.repository.PacienteDetalleRepository;
import com.clinica.service.PacienteDetalleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteDetalleServiceImpl implements PacienteDetalleService {

    @Autowired
    private PacienteDetalleRepository repository;

    @Override
    public List<PacienteDetalle> findAll() {
        return repository.findAll();
    }

    @Override
    public PacienteDetalle findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PacienteDetalle no encontrado: " + id));
    }

    @Override
    public PacienteDetalle save(PacienteDetalle paciente) {
        return repository.save(paciente);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("PacienteDetalle no encontrado: " + id);
        }
        repository.deleteById(id);
    }
}
