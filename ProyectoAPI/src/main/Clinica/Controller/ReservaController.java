package com.clinica.controller;

import com.clinica.model.Reserva;
import com.clinica.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtener(@PathVariable Integer id) {
        return reservaService.obtenerReserva(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reserva crear(@RequestBody Reserva reserva) {
        return reservaService.crearReserva(reserva);
    }

    @PutMapping("/{id}")
    public Reserva actualizar(@PathVariable Integer id, @RequestBody Reserva reserva) {
        return reservaService.actualizarReserva(id, reserva);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        reservaService.eliminarReserva(id);
    }

    // Endpoint extra: contar reservas por usuario
    @GetMapping("/usuario/{usuarioId}/cantidad")
    public long contarReservasPorUsuario(@PathVariable Integer usuarioId) {
        return reservaService.contarReservasPorUsuario(usuarioId);
    }
}