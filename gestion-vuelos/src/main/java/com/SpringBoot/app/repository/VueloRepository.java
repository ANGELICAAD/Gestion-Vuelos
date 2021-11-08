package com.SpringBoot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.app.entity.Vuelo;

/**
 * Clase corresponidente al repositorio de vuelo
 * @author Angelica Arroyave Duque
 *
 */
@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

}
