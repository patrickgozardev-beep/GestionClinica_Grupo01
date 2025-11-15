package com.clinica.controller;

import com.clinica.model.Especialista;
import com.clinica.service.EspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialistas")
public class EspecialistaController {

    @Autowired
    private EspecialistaService especialistaService;

    @GetMapping
    public List<Especialista> listar() {
        return especialistaService.listarEspecialistas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialista> obtener(@PathVariable Integer id) {
        return especialistaService.obtenerEspecialista(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Especialista crear(@RequestBody Especialista especialista) {
        return especialistaService.crearEspecialista(especialista);
    }

    @PutMapping("/{id}")
    public Especialista actualizar(@PathVariable Integer id, @RequestBody Especialista especialista) {
        return especialistaService.actualizarEspecialista(id, especialista);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        especialistaService.eliminarEspecialista(id);
    }
}