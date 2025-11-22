package com.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "plantillas_horarios")
public class PlantillaHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "espacio_id", nullable = false)
    private Espacio espacio;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    public enum Tipo {
        recurrente, puntual
    }

    private String diasSemana;

    private java.sql.Time horaInicio;
    private java.sql.Time horaFin;

    private java.sql.Date fechaInicio;
    private java.sql.Date fechaFin;

    private Integer intervaloMinutos;

    private boolean activo;

    @Column(name = "creado_en")
    private java.sql.Timestamp creadoEn;

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Espacio getEspacio() { return espacio; }
    public void setEspacio(Espacio espacio) { this.espacio = espacio; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    public String getDiasSemana() { return diasSemana; }
    public void setDiasSemana(String diasSemana) { this.diasSemana = diasSemana; }

    public java.sql.Time getHoraInicio() { return horaInicio; }
    public void setHoraInicio(java.sql.Time horaInicio) { this.horaInicio = horaInicio; }

    public java.sql.Time getHoraFin() { return horaFin; }
    public void setHoraFin(java.sql.Time horaFin) { this.horaFin = horaFin; }

    public java.sql.Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(java.sql.Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public java.sql.Date getFechaFin() { return fechaFin; }
    public void setFechaFin(java.sql.Date fechaFin) { this.fechaFin = fechaFin; }

    public Integer getIntervaloMinutos() { return intervaloMinutos; }
    public void setIntervaloMinutos(Integer intervaloMinutos) { this.intervaloMinutos = intervaloMinutos; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public java.sql.Timestamp getCreadoEn() { return creadoEn; }
    public void setCreadoEn(java.sql.Timestamp creadoEn) { this.creadoEn = creadoEn; }
}
