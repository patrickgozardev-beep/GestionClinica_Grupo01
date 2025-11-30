package com.clinica.controller;

import com.clinica.dto.PlantillaHorarioDto;
import com.clinica.service.PlantillaHorarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plantillas-horario")
@CrossOrigin(origins = "http://localhost:5173")
public class PlantillaHorarioController {

    @Autowired
    private PlantillaHorarioService service;

    @GetMapping
    public List<PlantillaHorarioDto> findAll() {
        return service.findAllDTO();
    }

    @GetMapping("/{id}")
    public PlantillaHorarioDto findById(@PathVariable Long id) {
        return service.findByIdDTO(id);
    }

    @PostMapping
    public PlantillaHorarioDto create(@RequestBody PlantillaHorarioDto dto) {
        return service.saveFromDTO(dto);
    }

    @PutMapping("/{id}")
    public PlantillaHorarioDto update(@PathVariable Long id, @RequestBody PlantillaHorarioDto dto) {
        dto.setId(id);
        return service.saveFromDTO(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
