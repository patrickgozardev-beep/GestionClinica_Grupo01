package com.clinica.service;

import java.util.List;
import com.clinica.model.Notificacion;

public interface NotificacionService {
    List<Notificacion> findAll();
    Notificacion findById(Long id);
    Notificacion save(Notificacion notificacion);
    void delete(Long id);
}
