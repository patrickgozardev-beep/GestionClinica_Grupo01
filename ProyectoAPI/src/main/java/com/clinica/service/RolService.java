package com.clinica.service;

import java.util.List;
import com.clinica.model.Rol;

public interface RolService {
    List<Rol> findAll();
    Rol findById(Short id);
    Rol save(Rol rol);
    void delete(Short id);
}
