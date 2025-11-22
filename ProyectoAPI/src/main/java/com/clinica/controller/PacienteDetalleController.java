package com.clinica.controller;

import com.clinica.model.PacienteDetalle;
import com.clinica.service.PacienteDetalleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes-detalle")
public class PacienteDetalleController {

    @Autowired
    private PacienteDetalleService service;

    @GetMapping
    public List<PacienteDetalle> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PacienteDetalle findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public PacienteDetalle create(@RequestBody PacienteDetalle paciente) {
        return service.save(paciente);
    }

    @PutMapping("/{id}")
    public PacienteDetalle update(@PathVariable Long id, @RequestBody PacienteDetalle paciente) {
        paciente.setId(id);
        return service.save(paciente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
