package com.clinica.service.impl;

import com.clinica.model.HorarioSlot;
import com.clinica.repository.HorarioSlotRepository;
import com.clinica.service.HorarioSlotService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioSlotServiceImpl implements HorarioSlotService {

    @Autowired
    private HorarioSlotRepository repository;

    @Override
    public List<HorarioSlot> findAll() {
        return repository.findAll();
    }

    @Override
    public HorarioSlot findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("HorarioSlot no encontrado: " + id));
    }

    @Override
    public HorarioSlot save(HorarioSlot slot) {
        return repository.save(slot);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("HorarioSlot no encontrado: " + id);
        }
        repository.deleteById(id);
    }
}
