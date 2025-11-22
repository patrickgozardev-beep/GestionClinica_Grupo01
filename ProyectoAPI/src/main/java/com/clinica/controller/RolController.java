package com.clinica.controller;

import com.clinica.model.Rol;
import com.clinica.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping
    public List<Rol> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Rol findById(@PathVariable Short id) {
        return service.findById(id);
    }

    @PostMapping
    public Rol create(@RequestBody Rol rol) {
        return service.save(rol);
    }

    @PutMapping("/{id}")
    public Rol update(@PathVariable Short id, @RequestBody Rol rol) {
        rol.setId(id);
        return service.save(rol);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Short id) {
        service.delete(id);
    }
}
