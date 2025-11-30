package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.model.HorarioSlot;

import java.sql.Date;
import java.util.List;

@Repository
public interface HorarioSlotRepository extends JpaRepository<HorarioSlot, Long> {
    List<HorarioSlot> findByFecha(Date fecha);

    List<HorarioSlot> findByFechaBetween(Date fechaInicio, Date fechaFin);
}
