package com.clinica.repository;

import com.clinica.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {
    List<Horario> findByFecha(LocalDate fecha);
}