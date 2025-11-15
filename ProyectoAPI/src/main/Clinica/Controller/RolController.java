package com.clinica.controller;

import com.clinica.model.Rol;
import com.clinica.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> listar() {
        return rolService.listarRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtener(@PathVariable Integer id) {
        return rolService.obtenerRol(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rol crear(@RequestBody Rol rol) {
        return rolService.crearRol(rol);
    }

    @PutMapping("/{id}")
    public Rol actualizar(@PathVariable Integer id, @RequestBody Rol rol) {
        return rolService.actualizarRol(id, rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        rolService.eliminarRol(id);
    }
}