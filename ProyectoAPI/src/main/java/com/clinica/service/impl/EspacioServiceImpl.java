package com.clinica.service.impl;

import com.clinica.model.Espacio;
import com.clinica.repository.EspacioRepository;
import com.clinica.service.EspacioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EspacioServiceImpl implements EspacioService {

    @Autowired
    private EspacioRepository repository;

    @Override
    public List<Espacio> findAll() {
        return repository.findAll();
    }

    @Override
    public Espacio findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Espacio no encontrado: " + id));
    }

    @Override
    public Espacio save(Espacio espacio) {
        return repository.save(espacio);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Espacio no encontrado: " + id);
        }
        repository.deleteById(id);
    }
}
