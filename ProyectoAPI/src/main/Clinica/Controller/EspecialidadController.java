package com.clinica.controller;

import com.clinica.model.Especialidad;
import com.clinica.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public List<Especialidad> listar() {
        return especialidadService.listarEspecialidades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> obtener(@PathVariable Integer id) {
        return especialidadService.obtenerEspecialidad(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Especialidad crear(@RequestBody Especialidad especialidad) {
        return especialidadService.crearEspecialidad(especialidad);
    }

    @PutMapping("/{id}")
    public Especialidad actualizar(@PathVariable Integer id, @RequestBody Especialidad especialidad) {
        return especialidadService.actualizarEspecialidad(id, especialidad);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        especialidadService.eliminarEspecialidad(id);
    }
}