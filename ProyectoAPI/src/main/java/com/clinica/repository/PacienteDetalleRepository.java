package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.model.PacienteDetalle;

@Repository
public interface PacienteDetalleRepository extends JpaRepository<PacienteDetalle, Long> {

}
