package com.clinica.service.impl;

import com.clinica.model.Notificacion;
import com.clinica.repository.NotificacionRepository;
import com.clinica.service.NotificacionService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    private NotificacionRepository repository;

    @Override
    public List<Notificacion> findAll() {
        return repository.findAll();
    }

    @Override
    public Notificacion findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notificación no encontrada: " + id));
    }

    @Override
    public Notificacion save(Notificacion notificacion) {
        return repository.save(notificacion);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Notificación no encontrada: " + id);
        }
        repository.deleteById(id);
    }
}
