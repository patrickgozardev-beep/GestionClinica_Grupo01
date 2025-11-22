package com.clinica.controller;

import com.clinica.model.Auditoria;
import com.clinica.service.AuditoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditorias")
public class AuditoriaController {

    @Autowired
    private AuditoriaService service;

    @GetMapping
    public List<Auditoria> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Auditoria findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Auditoria create(@RequestBody Auditoria auditoria) {
        return service.save(auditoria);
    }

    @PutMapping("/{id}")
    public Auditoria update(@PathVariable Long id, @RequestBody Auditoria auditoria) {
        auditoria.setId(id);
        return service.save(auditoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
