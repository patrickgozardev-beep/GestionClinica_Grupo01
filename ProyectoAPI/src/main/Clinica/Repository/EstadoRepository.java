package com.clinica.repository;

import com.clinica.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    // Contar reservas por usuario
    long countByUsuarioUsuarioId(Integer usuarioId);

    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.usuario.usuarioId = :usuarioId")
    long contarReservasPorUsuario(@Param("usuarioId") Integer usuarioId);
}