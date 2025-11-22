package com.clinica.controller;

import com.clinica.model.PlantillaHorario;
import com.clinica.service.PlantillaHorarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plantillas-horario")
public class PlantillaHorarioController {

    @Autowired
    private PlantillaHorarioService service;

    @GetMapping
    public List<PlantillaHorario> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PlantillaHorario findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public PlantillaHorario create(@RequestBody PlantillaHorario plantilla) {
        return service.save(plantilla);
    }

    @PutMapping("/{id}")
    public PlantillaHorario update(@PathVariable Long id, @RequestBody PlantillaHorario plantilla) {
        plantilla.setId(id);
        return service.save(plantilla);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
