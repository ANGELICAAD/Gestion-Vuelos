package com.SpringBoot.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringBoot.app.entity.Ruta;
import com.SpringBoot.app.repository.RutaRepository;

/**
 * Clase ruta service que implementa los métodos necesarios de la clase interface
 *  @author Angelica Arroyave Duque
 *
 */
@Service
public class RutaServiceImpl implements RutaService {

	@Autowired
	private RutaRepository rutaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Ruta> findAll() {
		return rutaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Ruta> findAll(Pageable pageable) {
		return rutaRepository.findAll(pageable);
	}
}
