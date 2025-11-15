package com.clinica.controller;

import com.clinica.model.Estado;
import com.clinica.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> listar() {
        return estadoService.listarEstados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> obtener(@PathVariable Integer id) {
        return estadoService.obtenerEstado(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estado crear(@RequestBody Estado estado) {
        return estadoService.crearEstado(estado);
    }

    @PutMapping("/{id}")
    public Estado actualizar(@PathVariable Integer id, @RequestBody Estado estado) {
        return estadoService.actualizarEstado(id, estado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        estadoService.eliminarEstado(id);
    }
}