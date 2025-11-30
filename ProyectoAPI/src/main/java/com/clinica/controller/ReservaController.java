package com.clinica.controller;

import com.clinica.model.Reserva;
import com.clinica.service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "http://localhost:5173")

public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public List<Reserva> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Reserva findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Reserva create(@RequestBody Reserva reserva) {
        return service.save(reserva);
    }

    @PutMapping("/{id}")
    public Reserva update(@PathVariable Long id, @RequestBody Reserva reserva) {
        reserva.setId(id);
        return service.save(reserva);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
