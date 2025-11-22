package com.clinica.service;

import java.util.List;
import com.clinica.model.Configuracion;

public interface ConfiguracionService {
    List<Configuracion> findAll();
    Configuracion findById(Integer id);
    Configuracion save(Configuracion config);
    void delete(Integer id);
}
