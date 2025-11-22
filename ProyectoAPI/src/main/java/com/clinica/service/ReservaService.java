package com.clinica.service;

import java.util.List;
import com.clinica.model.Reserva;

public interface ReservaService {
    List<Reserva> findAll();
    Reserva findById(Long id);
    Reserva save(Reserva reserva);
    void delete(Long id);
}
