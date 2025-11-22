package com.clinica.service.impl;

import com.clinica.model.Configuracion;
import com.clinica.repository.ConfiguracionRepository;
import com.clinica.service.ConfiguracionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConfiguracionServiceImpl implements ConfiguracionService {

    @Autowired
    private ConfiguracionRepository repository;

    @Override
    public List<Configuracion> findAll() {
        return repository.findAll();
    }

    @Override
    public Configuracion findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Configuración no encontrada: " + id));
    }

    @Override
    public Configuracion save(Configuracion config) {
        return repository.save(config);
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Configuración no encontrada: " + id);
        }
        repository.deleteById(id);
    }
}
