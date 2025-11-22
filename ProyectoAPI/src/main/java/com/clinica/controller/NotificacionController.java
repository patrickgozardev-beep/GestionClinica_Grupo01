package com.clinica.controller;

import com.clinica.model.Notificacion;
import com.clinica.service.NotificacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @GetMapping
    public List<Notificacion> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Notificacion findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Notificacion create(@RequestBody Notificacion notificacion) {
        return service.save(notificacion);
    }

    @PutMapping("/{id}")
    public Notificacion update(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        notificacion.setId(id);
        return service.save(notificacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
