package com.clinica.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "password_hash", length = 255, nullable = false)
    private String passwordHash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_usuario_rol"))
    private Rol rol;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public Usuario() {}

    @PrePersist
    public void prePersist() {
        if (fechaRegistro == null) {
            fechaRegistro = LocalDateTime.now();
        }
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}