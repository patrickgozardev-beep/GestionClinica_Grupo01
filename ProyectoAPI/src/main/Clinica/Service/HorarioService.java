package com.clinica.service;

import com.clinica.model.Horario;
import com.clinica.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> listarHorarios() {
        return horarioRepository.findAll();
    }

    public Optional<Horario> obtenerHorario(Integer id) {
        return horarioRepository.findById(id);
    }

    public Horario crearHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public Horario actualizarHorario(Integer id, Horario horario) {
        horario.setHorarioId(id);
        return horarioRepository.save(horario);
    }

    public void eliminarHorario(Integer id) {
        horarioRepository.deleteById(id);
    }

    public List<Horario> listarPorFecha(LocalDate fecha) {
        return horarioRepository.findByFecha(fecha);
    }
}