package com.clinica.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id")
    private Integer reservaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_reservas_usuario"))
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_reservas_horario"))
    private Horario horario;

    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_reservas_estado"))
    private Estado estado;

    @Column(name = "confirmacion_enviada")
    private Boolean confirmacionEnviada = false;

    public Reserva() {}

    @PrePersist
    public void prePersist() {
        if (fechaReserva == null) {
            fechaReserva = LocalDateTime.now();
        }
        if (confirmacionEnviada == null) {
            confirmacionEnviada = false;
        }
    }

    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Boolean getConfirmacionEnviada() {
        return confirmacionEnviada;
    }

    public void setConfirmacionEnviada(Boolean confirmacionEnviada) {
        this.confirmacionEnviada = confirmacionEnviada;
    }
}