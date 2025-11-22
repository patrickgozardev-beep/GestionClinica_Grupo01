package com.clinica.service;

import java.util.List;
import com.clinica.model.Auditoria;

public interface AuditoriaService {
    List<Auditoria> findAll();
    Auditoria findById(Long id);
    Auditoria save(Auditoria auditoria);
    void delete(Long id);
}
