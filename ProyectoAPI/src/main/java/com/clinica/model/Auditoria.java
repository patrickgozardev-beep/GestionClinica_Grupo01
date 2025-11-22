package com.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_actor_id")
    private Usuario usuarioActor;

    private String accion;

    private String recurso;

    private Long recursoId;

    @Column(columnDefinition = "json")
    private String detalles;

    @Column(name = "creado_en")
    private java.sql.Timestamp creadoEn;

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuarioActor() { return usuarioActor; }
    public void setUsuarioActor(Usuario usuarioActor) { this.usuarioActor = usuarioActor; }

    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }

    public String getRecurso() { return recurso; }
    public void setRecurso(String recurso) { this.recurso = recurso; }

    public Long getRecursoId() { return recursoId; }
    public void setRecursoId(Long recursoId) { this.recursoId = recursoId; }

    public String getDetalles() { return detalles; }
    public void setDetalles(String detalles) { this.detalles = detalles; }

    public java.sql.Timestamp getCreadoEn() { return creadoEn; }
    public void setCreadoEn(java.sql.Timestamp creadoEn) { this.creadoEn = creadoEn; }
}
