package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.model.DoctorDetalle;

@Repository
public interface DoctorDetalleRepository extends JpaRepository<DoctorDetalle, Long> {

}
