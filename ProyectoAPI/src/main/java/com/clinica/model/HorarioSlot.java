package com.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "horarios_slots",
    uniqueConstraints = @UniqueConstraint(columnNames = {"espacio_id", "fecha", "hora_inicio"})
)
public class HorarioSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "espacio_id", nullable = false)
    private Espacio espacio;

    @ManyToOne
    @JoinColumn(name = "plantilla_id")
    private PlantillaHorario plantilla;

    private java.sql.Date fecha;

    private java.sql.Time horaInicio;
    private java.sql.Time horaFin;

    private Integer capacidad;

    private Integer contadorActual;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public enum Estado {
        disponible, lleno, cerrado
    }

    @Column(name = "creado_en")
    private java.sql.Timestamp creadoEn;

    @Column(name = "actualizado_en")
    private java.sql.Timestamp actualizadoEn;

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Espacio getEspacio() { return espacio; }
    public void setEspacio(Espacio espacio) { this.espacio = espacio; }

    public PlantillaHorario getPlantilla() { return plantilla; }
    public void setPlantilla(PlantillaHorario plantilla) { this.plantilla = plantilla; }

    public java.sql.Date getFecha() { return fecha; }
    public void setFecha(java.sql.Date fecha) { this.fecha = fecha; }

    public java.sql.Time getHoraInicio() { return horaInicio; }
    public void setHoraInicio(java.sql.Time horaInicio) { this.horaInicio = horaInicio; }

    public java.sql.Time getHoraFin() { return horaFin; }
    public void setHoraFin(java.sql.Time horaFin) { this.horaFin = horaFin; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public Integer getContadorActual() { return contadorActual; }
    public void setContadorActual(Integer contadorActual) { this.contadorActual = contadorActual; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public java.sql.Timestamp getCreadoEn() { return creadoEn; }
    public void setCreadoEn(java.sql.Timestamp creadoEn) { this.creadoEn = creadoEn; }

    public java.sql.Timestamp getActualizadoEn() { return actualizadoEn; }
    public void setActualizadoEn(java.sql.Timestamp actualizadoEn) { this.actualizadoEn = actualizadoEn; }
}
