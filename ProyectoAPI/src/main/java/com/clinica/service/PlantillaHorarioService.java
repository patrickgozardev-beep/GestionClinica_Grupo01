package com.clinica.service;

import java.util.List;
import com.clinica.model.PlantillaHorario;

public interface PlantillaHorarioService {
    List<PlantillaHorario> findAll();
    PlantillaHorario findById(Long id);
    PlantillaHorario save(PlantillaHorario plantilla);
    void delete(Long id);
}
