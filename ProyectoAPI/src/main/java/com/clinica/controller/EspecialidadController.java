package com.clinica.controller;

import com.clinica.model.Especialidad;
import com.clinica.service.EspecialidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
@CrossOrigin(origins = "http://localhost:5173")

public class EspecialidadController {

    @Autowired
    private EspecialidadService service;

    @GetMapping
    public List<Especialidad> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Especialidad findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Especialidad create(@RequestBody Especialidad especialidad) {
        return service.save(especialidad);
    }

    @PutMapping("/{id}")
    public Especialidad update(@PathVariable Integer id, @RequestBody Especialidad especialidad) {
        especialidad.setId(id);
        return service.save(especialidad);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


}
