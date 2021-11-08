package com.SpringBoot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.Query;

import com.SpringBoot.app.entity.Vuelo;

/**
 * Clase vuelo
 * @author Angelica Arroyave Duque
 *
 */
public interface VueloService {
	public Iterable<Vuelo> findAll();
	
	public Page<Vuelo> findAll(Pageable pageable);
	
	public Optional<Vuelo> findById(Long id);
	
	public List<Vuelo> listVuelos();
	
	public List<Vuelo> listVuelosFecha(String fecha);
	
	@Query(value = "select vuelo.numeroVuelo, vuelo.fecha from vuelo inner join ruta on vuelo.idVuelo = ruta.idVuelo")
	public List<Vuelo> listVuelosRuta();
	
	public Vuelo guardarVuelo(Vuelo vuelo);
	
	public Vuelo actualizarVuelo(Vuelo vuelo);
	
	public void eliminarVuelo(Long id);
}
