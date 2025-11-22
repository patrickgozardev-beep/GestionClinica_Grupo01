package com.clinica.controller;

import com.clinica.model.HorarioSlot;
import com.clinica.service.HorarioSlotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios-slots")
public class HorarioSlotController {

    @Autowired
    private HorarioSlotService service;

    @GetMapping
    public List<HorarioSlot> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public HorarioSlot findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public HorarioSlot create(@RequestBody HorarioSlot slot) {
        return service.save(slot);
    }

    @PutMapping("/{id}")
    public HorarioSlot update(@PathVariable Long id, @RequestBody HorarioSlot slot) {
        slot.setId(id);
        return service.save(slot);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
