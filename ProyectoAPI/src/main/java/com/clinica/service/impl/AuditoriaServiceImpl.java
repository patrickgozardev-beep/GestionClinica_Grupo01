package com.clinica.service.impl;

import com.clinica.model.Auditoria;
import com.clinica.repository.AuditoriaRepository;
import com.clinica.service.AuditoriaService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

    @Autowired
    private AuditoriaRepository repository;

    @Override
    public List<Auditoria> findAll() {
        return repository.findAll();
    }

    @Override
    public Auditoria findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Auditoría no encontrada: " + id));
    }

    @Override
    public Auditoria save(Auditoria auditoria) {
        return repository.save(auditoria);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Auditoría no encontrada: " + id);
        }
        repository.deleteById(id);
    }
}
