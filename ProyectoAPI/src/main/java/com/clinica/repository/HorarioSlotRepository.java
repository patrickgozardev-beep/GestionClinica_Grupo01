package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.model.HorarioSlot;

@Repository
public interface HorarioSlotRepository extends JpaRepository<HorarioSlot, Long> {

}
