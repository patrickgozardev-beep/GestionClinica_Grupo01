package com.clinica.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificacion_id")
    private Integer notificacionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_notificacion_reserva"))
    private Reserva reserva;

    @Column(name = "descripcion", length = 255, nullable = false)
    private String descripcion;

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio;

    public Notificacion() {}

    @PrePersist
    public void prePersist() {
        if (fechaEnvio == null) {
            fechaEnvio = LocalDateTime.now();
        }
    }

    public Integer getNotificacionId() {
        return notificacionId;
    }

    public void setNotificacionId(Integer notificacionId) {
        this.notificacionId = notificacionId;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}