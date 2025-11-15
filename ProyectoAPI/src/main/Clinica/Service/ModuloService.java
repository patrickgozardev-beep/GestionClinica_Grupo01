package com.clinica.service;

import com.clinica.model.Modulo;
import com.clinica.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public List<Modulo> listarModulos() {
        return moduloRepository.findAll();
    }

    public Optional<Modulo> obtenerModulo(Integer id) {
        return moduloRepository.findById(id);
    }

    public Modulo crearModulo(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    public Modulo actualizarModulo(Integer id, Modulo modulo) {
        modulo.setModuloId(id);
        return moduloRepository.save(modulo);
    }

    public void eliminarModulo(Integer id) {
        moduloRepository.deleteById(id);
    }
}