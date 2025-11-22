package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinica.model.Espacio;

@Repository
public interface EspacioRepository extends JpaRepository<Espacio, Long> {

}
