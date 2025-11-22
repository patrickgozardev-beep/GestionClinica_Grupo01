package com.clinica.service.impl;

import com.clinica.model.DoctorDetalle;
import com.clinica.repository.DoctorDetalleRepository;
import com.clinica.service.DoctorDetalleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorDetalleServiceImpl implements DoctorDetalleService {

    @Autowired
    private DoctorDetalleRepository repository;

    @Override
    public List<DoctorDetalle> findAll() {
        return repository.findAll();
    }

    @Override
    public DoctorDetalle findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DoctorDetalle no encontrado: " + id));
    }

    @Override
    public DoctorDetalle save(DoctorDetalle doctor) {
        return repository.save(doctor);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("DoctorDetalle no encontrado: " + id);
        }
        repository.deleteById(id);
    }
}
