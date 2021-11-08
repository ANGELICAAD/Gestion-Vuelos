package com.SpringBoot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.app.entity.Ruta;

/**
 * Clase corresponidente al repositorio de ruta
 * @author Angelica Arroyave Duque
 *
 */
@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {

}
