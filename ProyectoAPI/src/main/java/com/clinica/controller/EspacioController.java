package com.clinica.controller;

import com.clinica.model.Espacio;
import com.clinica.service.EspacioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
public class EspacioController {

    @Autowired
    private EspacioService service;

    @GetMapping
    public List<Espacio> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Espacio findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Espacio create(@RequestBody Espacio espacio) {
        return service.save(espacio);
    }

    @PutMapping("/{id}")
    public Espacio update(@PathVariable Long id, @RequestBody Espacio espacio) {
        espacio.setId(id);
        return service.save(espacio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
