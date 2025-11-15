package com.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Modulo")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modulo_id")
    private Integer moduloId;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "piso", nullable = false)
    private Integer piso;

    @Column(name = "capacidad_maxima", nullable = false)
    private Integer capacidadMaxima;

    public Modulo() {}

    public Integer getModuloId() {
        return moduloId;
    }

    public void setModuloId(Integer moduloId) {
        this.moduloId = moduloId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
}