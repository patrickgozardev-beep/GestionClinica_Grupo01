package com.clinica.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Especialista")
public class Especialista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "especialista_id")
    private Integer especialistaId;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "email", length = 150, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialidad_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_especialista_especialidad"))
    private Especialidad especialidad;

    @Column(name = "fecha_contratacion")
    private LocalDate fechaContratacion;

    @Column(name = "activo")
    private Boolean activo = true;

    public Especialista() {}

    @PrePersist
    public void prePersist() {
        if (fechaContratacion == null) {
            fechaContratacion = LocalDate.now();
        }
        if (activo == null) {
            activo = true;
        }
    }

    public Integer getEspecialistaId() {
        return especialistaId;
    }

    public void setEspecialistaId(Integer especialistaId) {
        this.especialistaId = especialistaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}