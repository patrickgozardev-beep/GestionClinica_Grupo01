package com.clinica.service;

import java.util.List;
import com.clinica.model.Espacio;

public interface EspacioService {
    List<Espacio> findAll();
    Espacio findById(Long id);
    Espacio save(Espacio espacio);
    void delete(Long id);
}
