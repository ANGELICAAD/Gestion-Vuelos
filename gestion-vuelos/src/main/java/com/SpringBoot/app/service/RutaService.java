package com.SpringBoot.app.service;

import org.springframework.data.domain.*;

import com.SpringBoot.app.entity.Ruta;

/**
 * Clase ruta
 * @author Angelica Arroyave Duque
 *
 */
public interface RutaService {
	public Iterable<Ruta> findAll();
	
	public Page<Ruta> findAll(Pageable pageable);
}
