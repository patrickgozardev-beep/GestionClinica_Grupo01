package com.clinica.service.impl;

import com.clinica.model.PlantillaHorario;
import com.clinica.repository.PlantillaHorarioRepository;
import com.clinica.service.PlantillaHorarioService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlantillaHorarioServiceImpl implements PlantillaHorarioService {

    @Autowired
    private PlantillaHorarioRepository repository;

    @Override
    public List<PlantillaHorario> findAll() {
        return repository.findAll();
    }

    @Override
    public PlantillaHorario findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PlantillaHorario no encontrada: " + id));
    }

    @Override
    public PlantillaHorario save(PlantillaHorario plantilla) {
        return repository.save(plantilla);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("PlantillaHorario no encontrada: " + id);
        }
        repository.deleteById(id);
    }
}
