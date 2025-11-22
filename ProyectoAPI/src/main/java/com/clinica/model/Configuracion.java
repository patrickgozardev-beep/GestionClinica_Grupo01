package com.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "configuracion")
public class Configuracion {

    @Id
    private Integer id;

    private Short umbralAlertaAforo;
    private Integer maxUsuariosConcurrentes;
    private Integer tiempoExpiracionReservaSegundos;

    @Column(name = "creado_en")
    private java.sql.Timestamp creadoEn;

    @Column(name = "actualizado_en")
    private java.sql.Timestamp actualizadoEn;

    // GETTERS & SETTERS
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Short getUmbralAlertaAforo() { return umbralAlertaAforo; }
    public void setUmbralAlertaAforo(Short u) { this.umbralAlertaAforo = u; }

    public Integer getMaxUsuariosConcurrentes() { return maxUsuariosConcurrentes; }
    public void setMaxUsuariosConcurrentes(Integer m) { this.maxUsuariosConcurrentes = m; }

    public Integer getTiempoExpiracionReservaSegundos() { return tiempoExpiracionReservaSegundos; }
    public void setTiempoExpiracionReservaSegundos(Integer t) { this.tiempoExpiracionReservaSegundos = t; }

    public java.sql.Timestamp getCreadoEn() { return creadoEn; }
    public void setCreadoEn(java.sql.Timestamp c) { this.creadoEn = c; }

    public java.sql.Timestamp getActualizadoEn() { return actualizadoEn; }
    public void setActualizadoEn(java.sql.Timestamp a) { this.actualizadoEn = a; }
}
