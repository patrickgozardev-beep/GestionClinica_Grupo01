package com.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes_detalles")
public class PacienteDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private java.sql.Date fechaNacimiento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public enum Sexo {
        masculino, femenino, otro
    }

    private String direccion;

    @Enumerated(EnumType.STRING)
    private TipoDocumento documentoTipo;

    public enum TipoDocumento {
        dni, ce, pasaporte
    }

    private String documentoNumero;

    private String historialMedico;

    @Column(name = "creado_en")
    private java.sql.Timestamp creadoEn;

    @Column(name = "actualizado_en")
    private java.sql.Timestamp actualizadoEn;

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public java.sql.Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(java.sql.Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Sexo getSexo() { return sexo; }
    public void setSexo(Sexo sexo) { this.sexo = sexo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public TipoDocumento getDocumentoTipo() { return documentoTipo; }
    public void setDocumentoTipo(TipoDocumento t) { this.documentoTipo = t; }

    public String getDocumentoNumero() { return documentoNumero; }
    public void setDocumentoNumero(String documentoNumero) { this.documentoNumero = documentoNumero; }

    public String getHistorialMedico() { return historialMedico; }
    public void setHistorialMedico(String historialMedico) { this.historialMedico = historialMedico; }

    public java.sql.Timestamp getCreadoEn() { return creadoEn; }
    public void setCreadoEn(java.sql.Timestamp creadoEn) { this.creadoEn = creadoEn; }

    public java.sql.Timestamp getActualizadoEn() { return actualizadoEn; }
    public void setActualizadoEn(java.sql.Timestamp actualizadoEn) { this.actualizadoEn = actualizadoEn; }
}
