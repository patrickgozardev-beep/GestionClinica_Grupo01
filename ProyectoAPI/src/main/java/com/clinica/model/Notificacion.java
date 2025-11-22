package com.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notificaciones")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private HorarioSlot slot;

    private String tipo;

    private String mensaje;

    @Enumerated(EnumType.STRING)
    private Canal canal;

    public enum Canal {
        email, interna
    }

    private boolean entregado;

    @Column(name = "creado_en")
    private java.sql.Timestamp creadoEn;

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public HorarioSlot getSlot() { return slot; }
    public void setSlot(HorarioSlot slot) { this.slot = slot; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public Canal getCanal() { return canal; }
    public void setCanal(Canal canal) { this.canal = canal; }

    public boolean isEntregado() { return entregado; }
    public void setEntregado(boolean entregado) { this.entregado = entregado; }

    public java.sql.Timestamp getCreadoEn() { return creadoEn; }
    public void setCreadoEn(java.sql.Timestamp creadoEn) { this.creadoEn = creadoEn; }
}
