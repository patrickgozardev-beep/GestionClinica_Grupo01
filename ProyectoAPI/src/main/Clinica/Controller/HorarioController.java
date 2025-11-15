package com.clinica.controller;

import com.clinica.model.Horario;
import com.clinica.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public List<Horario> listar() {
        return horarioService.listarHorarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> obtener(@PathVariable Integer id) {
        return horarioService.obtenerHorario(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Horario crear(@RequestBody Horario horario) {
        return horarioService.crearHorario(horario);
    }

    @PutMapping("/{id}")
    public Horario actualizar(@PathVariable Integer id, @RequestBody Horario horario) {
        return horarioService.actualizarHorario(id, horario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        horarioService.eliminarHorario(id);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Horario> listarPorFecha(@PathVariable String fecha) {
        return horarioService.listarPorFecha(LocalDate.parse(fecha));
    }
}