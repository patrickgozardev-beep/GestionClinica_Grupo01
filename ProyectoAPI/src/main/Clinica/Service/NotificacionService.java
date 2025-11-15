package com.clinica.service;

import com.clinica.model.Notificacion;
import com.clinica.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> listarNotificaciones() {
        return notificacionRepository.findAll();
    }

    public Optional<Notificacion> obtenerNotificacion(Integer id) {
        return notificacionRepository.findById(id);
    }

    public Notificacion crearNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Notificacion actualizarNotificacion(Integer id, Notificacion notificacion) {
        notificacion.setNotificacionId(id);
        return notificacionRepository.save(notificacion);
    }

    public void eliminarNotificacion(Integer id) {
        notificacionRepository.deleteById(id);
    }
}