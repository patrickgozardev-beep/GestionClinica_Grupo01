package com.clinica.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "horario_id")
    private Integer horarioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modulo_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_horarios_modulo"))
    private Modulo modulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialista_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_horarios_especialista"))
    private Especialista especialista;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @Column(name = "activo")
    private Boolean activo = true;

    public Horario() {}

    @PrePersist
    public void prePersist() {
        if (activo == null) {
            activo = true;
        }
    }

    public Integer getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Integer horarioId) {
        this.horarioId = horarioId;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}