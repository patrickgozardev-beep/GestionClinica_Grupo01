package com.clinica.controller;

import com.clinica.model.Configuracion;
import com.clinica.service.ConfiguracionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configuraciones")
public class ConfiguracionController {

    @Autowired
    private ConfiguracionService service;

    @GetMapping
    public List<Configuracion> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Configuracion findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Configuracion create(@RequestBody Configuracion configuracion) {
        return service.save(configuracion);
    }

    @PutMapping("/{id}")
    public Configuracion update(@PathVariable Integer id, @RequestBody Configuracion configuracion) {
        configuracion.setId(id);
        return service.save(configuracion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
