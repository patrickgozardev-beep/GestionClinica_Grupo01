package com.clinica.controller;

import com.clinica.model.DoctorDetalle;
import com.clinica.service.DoctorDetalleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores-detalle")
public class DoctorDetalleController {

    @Autowired
    private DoctorDetalleService service;

    @GetMapping
    public List<DoctorDetalle> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DoctorDetalle findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DoctorDetalle create(@RequestBody DoctorDetalle doctor) {
        return service.save(doctor);
    }

    @PutMapping("/{id}")
    public DoctorDetalle update(@PathVariable Long id, @RequestBody DoctorDetalle doctor) {
        doctor.setId(id);
        return service.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
