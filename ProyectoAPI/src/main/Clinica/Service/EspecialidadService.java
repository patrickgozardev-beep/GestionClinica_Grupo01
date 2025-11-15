package com.clinica.service;

import com.clinica.model.Especialidad;
import com.clinica.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> listarEspecialidades() {
        return especialidadRepository.findAll();
    }

    public Optional<Especialidad> obtenerEspecialidad(Integer id) {
        return especialidadRepository.findById(id);
    }

    public Especialidad crearEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public Especialidad actualizarEspecialidad(Integer id, Especialidad especialidad) {
        especialidad.setEspecialidadId(id);
        return especialidadRepository.save(especialidad);
    }

    public void eliminarEspecialidad(Integer id) {
        especialidadRepository.deleteById(id);
    }
}