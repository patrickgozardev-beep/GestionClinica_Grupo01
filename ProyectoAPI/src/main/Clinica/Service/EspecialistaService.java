package com.clinica.service;

import com.clinica.model.Especialista;
import com.clinica.repository.EspecialistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialistaService {

    @Autowired
    private EspecialistaRepository especialistaRepository;

    public List<Especialista> listarEspecialistas() {
        return especialistaRepository.findAll();
    }

    public Optional<Especialista> obtenerEspecialista(Integer id) {
        return especialistaRepository.findById(id);
    }

    public Especialista crearEspecialista(Especialista especialista) {
        return especialistaRepository.save(especialista);
    }

    public Especialista actualizarEspecialista(Integer id, Especialista especialista) {
        especialista.setEspecialistaId(id);
        return especialistaRepository.save(especialista);
    }

    public void eliminarEspecialista(Integer id) {
        especialistaRepository.deleteById(id);
    }
}