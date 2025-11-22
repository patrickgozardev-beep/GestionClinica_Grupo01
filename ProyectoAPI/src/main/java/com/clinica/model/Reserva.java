package com.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "reservas",
    uniqueConstraints = @UniqueConstraint(columnNames = {"paciente_id", "slot_id"})
)
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Usuario paciente;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Usuario doctor;

    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false)
    private HorarioSlot slot;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public enum Estado {
        confirmada, cancelada, asistida, no_show
    }

    private String motivoCancelacion;

    @Column(name = "creada_en")
    private java.sql.Timestamp creadaEn;

    @Column(name = "actualizada_en")
    private java.sql.Timestamp actualizadaEn;

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getPaciente() { return paciente; }
    public void setPaciente(Usuario paciente) { this.paciente = paciente; }

    public Usuario getDoctor() { return doctor; }
    public void setDoctor(Usuario doctor) { this.doctor = doctor; }

    public HorarioSlot getSlot() { return slot; }
    public void setSlot(HorarioSlot slot) { this.slot = slot; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public String getMotivoCancelacion() { return motivoCancelacion; }
    public void setMotivoCancelacion(String motivoCancelacion) { this.motivoCancelacion = motivoCancelacion; }

    public java.sql.Timestamp getCreadaEn() { return creadaEn; }
    public void setCreadaEn(java.sql.Timestamp creadaEn) { this.creadaEn = creadaEn; }

    public java.sql.Timestamp getActualizadaEn() { return actualizadaEn; }
    public void setActualizadaEn(java.sql.Timestamp actualizadaEn) { this.actualizadaEn = actualizadaEn; }
}
