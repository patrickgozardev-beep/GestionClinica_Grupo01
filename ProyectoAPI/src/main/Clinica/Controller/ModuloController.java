package com.clinica.controller;

import com.clinica.model.Modulo;
import com.clinica.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    @GetMapping
    public List<Modulo> listar() {
        return moduloService.listarModulos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modulo> obtener(@PathVariable Integer id) {
        return moduloService.obtenerModulo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Modulo crear(@RequestBody Modulo modulo) {
        return moduloService.crearModulo(modulo);
    }

    @PutMapping("/{id}")
    public Modulo actualizar(@PathVariable Integer id, @RequestBody Modulo modulo) {
        return moduloService.actualizarModulo(id, modulo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        moduloService.eliminarModulo(id);
    }
}