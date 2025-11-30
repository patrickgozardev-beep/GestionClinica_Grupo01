package com.clinica.service.impl;

import com.clinica.dto.PlantillaHorarioDto;
import com.clinica.model.Espacio;
import com.clinica.model.HorarioSlot;
import com.clinica.model.PlantillaHorario;
import com.clinica.repository.HorarioSlotRepository;
import com.clinica.repository.PlantillaHorarioRepository;
import com.clinica.service.PlantillaHorarioService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Service
public class PlantillaHorarioServiceImpl implements PlantillaHorarioService {

    @Autowired
    private PlantillaHorarioRepository repository;

    @Autowired
    private HorarioSlotRepository slotRepository;

    // ==========================================================
    // CRUD BÁSICO
    // ==========================================================
    @Override
    public List<PlantillaHorario> findAll() {
        return repository.findAll();
    }

    @Override
    public PlantillaHorario findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PlantillaHorario no encontrado: " + id));
    }

    @Override
    public PlantillaHorario save(PlantillaHorario plantilla) {
        PlantillaHorario saved = repository.save(plantilla);
        generarSlotsDesdePlantilla(saved);
        return saved;
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("PlantillaHorario no encontrado: " + id);
        }
        repository.deleteById(id);
    }

    // ==========================================================
    // MÉTODOS DTO
    // ==========================================================
    @Override
    public List<PlantillaHorarioDto> findAllDTO() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public PlantillaHorarioDto findByIdDTO(Long id) {
        return toDTO(findById(id));
    }

    @Override
    public PlantillaHorarioDto saveFromDTO(PlantillaHorarioDto dto) {
        PlantillaHorario plantilla = toEntity(dto);
        plantilla = save(plantilla);
        return toDTO(plantilla);
    }

    // ==========================================================
    // CONVERTIDORES DTO ↔ ENTIDAD
    // ==========================================================
    private PlantillaHorarioDto toDTO(PlantillaHorario p) {
        PlantillaHorarioDto dto = new PlantillaHorarioDto();

        dto.setId(p.getId());
        dto.setEspacioId(p.getEspacio().getId());

        dto.setNombre(p.getNombre());
        dto.setTipo(p.getTipo().name()); // <---- AQUÍ SE CONVIERTE ENUM → STRING

        dto.setDiasSemana(p.getDiasSemana());
        dto.setHoraInicio(p.getHoraInicio());
        dto.setHoraFin(p.getHoraFin());
        dto.setFechaInicio(p.getFechaInicio());
        dto.setFechaFin(p.getFechaFin());
        dto.setIntervaloMinutos(p.getIntervaloMinutos());
        dto.setActivo(p.isActivo());

        return dto;
    }


    private PlantillaHorario toEntity(PlantillaHorarioDto dto) {
        PlantillaHorario p = new PlantillaHorario();

        p.setId(dto.getId());

        // ESPACIO SOLO POR ID
        Espacio e = new Espacio();
        e.setId(dto.getEspacioId());
        p.setEspacio(e);

        p.setNombre(dto.getNombre());

        // <---- AQUÍ VA LA CONVERSIÓN STRING → ENUM
        p.setTipo(PlantillaHorario.Tipo.valueOf(dto.getTipo().toLowerCase()));

        p.setDiasSemana(dto.getDiasSemana());
        p.setHoraInicio(dto.getHoraInicio());
        p.setHoraFin(dto.getHoraFin());
        p.setFechaInicio(dto.getFechaInicio());
        p.setFechaFin(dto.getFechaFin());
        p.setIntervaloMinutos(dto.getIntervaloMinutos());
        p.setActivo(dto.isActivo());

        return p;
    }


    private void generarSlotsDesdePlantilla(PlantillaHorario plantilla) {

        if (plantilla.getTipo() == PlantillaHorario.Tipo.puntual) {
            generarSlotsParaFecha(plantilla, plantilla.getFechaInicio());
            return;
        }

        LocalDate inicio = plantilla.getFechaInicio().toLocalDate();
        LocalDate fin = plantilla.getFechaFin().toLocalDate();

        List<DayOfWeek> dias = Arrays.stream(
                        plantilla.getDiasSemana().split(",")
                )
                .map(String::trim)
                .map(this::convertirDia)
                .toList();

        LocalDate actual = inicio;

        while (!actual.isAfter(fin)) {
            if (dias.contains(actual.getDayOfWeek())) {
                generarSlotsParaFecha(plantilla, Date.valueOf(actual));
            }
            actual = actual.plusDays(1);
        }
    }

    // Convierte "LUNES" → DayOfWeek.MONDAY
    private DayOfWeek convertirDia(String dia) {

        return switch (dia.toUpperCase()) {
            case "LUNES" -> DayOfWeek.MONDAY;
            case "MARTES" -> DayOfWeek.TUESDAY;
            case "MIERCOLES", "MIÉRCOLES" -> DayOfWeek.WEDNESDAY;
            case "JUEVES" -> DayOfWeek.THURSDAY;
            case "VIERNES" -> DayOfWeek.FRIDAY;
            case "SABADO", "SÁBADO" -> DayOfWeek.SATURDAY;
            case "DOMINGO" -> DayOfWeek.SUNDAY;
            default -> throw new IllegalArgumentException("Día inválido: " + dia);
        };
    }

    private void generarSlotsParaFecha(PlantillaHorario plantilla, Date fecha) {

        LocalTime inicio = plantilla.getHoraInicio().toLocalTime();
        LocalTime fin = plantilla.getHoraFin().toLocalTime();

        LocalTime actual = inicio;

        while (!actual.plusMinutes(plantilla.getIntervaloMinutos()).isAfter(fin)) {

            HorarioSlot slot = new HorarioSlot();

            slot.setEspacio(plantilla.getEspacio());
            slot.setPlantilla(plantilla);

            slot.setFecha(fecha);
            slot.setHoraInicio(Time.valueOf(actual));
            slot.setHoraFin(Time.valueOf(actual.plusMinutes(plantilla.getIntervaloMinutos())));

            slot.setCapacidad(1);
            slot.setContadorActual(0);
            slot.setEstado(HorarioSlot.Estado.disponible);

            slot.setCreadoEn(new java.sql.Timestamp(System.currentTimeMillis()));

            slotRepository.save(slot);

            actual = actual.plusMinutes(plantilla.getIntervaloMinutos());
        }
    }
}
