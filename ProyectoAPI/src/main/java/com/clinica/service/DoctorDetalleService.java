package com.clinica.service;

import java.util.List;
import com.clinica.model.DoctorDetalle;

public interface DoctorDetalleService {
    List<DoctorDetalle> findAll();
    DoctorDetalle findById(Long id);
    DoctorDetalle save(DoctorDetalle doctor);
    void delete(Long id);
}
