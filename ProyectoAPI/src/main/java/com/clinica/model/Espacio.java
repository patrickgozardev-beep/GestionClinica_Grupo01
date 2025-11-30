package com.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "espacios")
public class Espacio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    private String descripcion;
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;

    private Integer capacidad;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public enum Estado {
        activo, inactivo
    }

    @ManyToOne
    @JoinColumn(name = "creado_por")
    private Usuario creadoPor;

    @Column(name = "creado_en")
    private java.sql.Timestamp creadoEn;

    @Column(name = "actualizado_en")
    private java.sql.Timestamp actualizadoEn;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public Especialidad getEspecialidad() { return especialidad; }
    public void setEspecialidad(Especialidad especialidad) { this.especialidad = especialidad; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public Usuario getCreadoPor() { return creadoPor; }
    public void setCreadoPor(Usuario creadoPor) { this.creadoPor = creadoPor; }

    public java.sql.Timestamp getCreadoEn() { return creadoEn; }
    public void setCreadoEn(java.sql.Timestamp creadoEn) { this.creadoEn = creadoEn; }

    public java.sql.Timestamp getActualizadoEn() { return actualizadoEn; }
    public void setActualizadoEn(java.sql.Timestamp actualizadoEn) { this.actualizadoEn = actualizadoEn; }
}
