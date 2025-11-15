package com.clinica.service;

import com.clinica.model.Reserva;
import com.clinica.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> obtenerReserva(Integer id) {
        return reservaRepository.findById(id);
    }

    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva actualizarReserva(Integer id, Reserva reserva) {
        reserva.setReservaId(id);
        return reservaRepository.save(reserva);
    }

    public void eliminarReserva(Integer id) {
        reservaRepository.deleteById(id);
    }

    // Método extra: contar reservas por usuario
    public long contarReservasPorUsuario(Integer usuarioId) {
        return reservaRepository.contarReservasPorUsuario(usuarioId);
    }
}