package com.clinica.service;

import java.util.List;
import com.clinica.model.Especialidad;

public interface EspecialidadService {
    List<Especialidad> findAll();
    Especialidad findById(Integer id);
    Especialidad save(Especialidad especialidad);
    void delete(Integer id);
}
