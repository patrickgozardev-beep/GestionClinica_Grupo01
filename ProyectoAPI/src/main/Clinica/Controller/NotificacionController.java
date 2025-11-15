package com.clinica.controller;

import com.clinica.model.Notificacion;
import com.clinica.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public List<Notificacion> listar() {
        return notificacionService.listarNotificaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> obtener(@PathVariable Integer id) {
        return notificacionService.obtenerNotificacion(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Notificacion crear(@RequestBody Notificacion notificacion) {
        return notificacionService.crearNotificacion(notificacion);
    }

    @PutMapping("/{id}")
    public Notificacion actualizar(@PathVariable Integer id, @RequestBody Notificacion notificacion) {
        return notificacionService.actualizarNotificacion(id, notificacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        notificacionService.eliminarNotificacion(id);
    }
}