package com.clinica.service;

import com.clinica.model.Estado;
import com.clinica.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> listarEstados() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> obtenerEstado(Integer id) {
        return estadoRepository.findById(id);
    }

    public Estado crearEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado actualizarEstado(Integer id, Estado estado) {
        estado.setEstadoId(id);
        return estadoRepository.save(estado);
    }

    public void eliminarEstado(Integer id) {
        estadoRepository.deleteById(id);
    }
}