package com.clinica.service;

import java.util.List;
import com.clinica.model.PacienteDetalle;

public interface PacienteDetalleService {
    List<PacienteDetalle> findAll();
    PacienteDetalle findById(Long id);
    PacienteDetalle save(PacienteDetalle paciente);
    void delete(Long id);
}
