package com.clinica.service;

import java.util.List;
import com.clinica.model.HorarioSlot;

public interface HorarioSlotService {
    List<HorarioSlot> findAll();
    HorarioSlot findById(Long id);
    HorarioSlot save(HorarioSlot slot);
    void delete(Long id);
}
