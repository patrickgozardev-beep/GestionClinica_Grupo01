package com.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doctores_detalles")
public class DoctorDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;

    private String numeroColegiatura;
    private Integer experienciaAnios;

    @Column(name = "creado_en")
    private java.sql.Timestamp creadoEn;

    @Column(name = "actualizado_en")
    private java.sql.Timestamp actualizadoEn;

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Especialidad getEspecialidad() { return especialidad; }
    public void setEspecialidad(Especialidad especialidad) { this.especialidad = especialidad; }

    public String getNumeroColegiatura() { return numeroColegiatura; }
    public void setNumeroColegiatura(String numeroColegiatura) { this.numeroColegiatura = numeroColegiatura; }

    public Integer getExperienciaAnios() { return experienciaAnios; }
    public void setExperienciaAnios(Integer experienciaAnios) { this.experienciaAnios = experienciaAnios; }

    public java.sql.Timestamp getCreadoEn() { return creadoEn; }
    public void setCreadoEn(java.sql.Timestamp creadoEn) { this.creadoEn = creadoEn; }

    public java.sql.Timestamp getActualizadoEn() { return actualizadoEn; }
    public void setActualizadoEn(java.sql.Timestamp actualizadoEn) { this.actualizadoEn = actualizadoEn; }
}
