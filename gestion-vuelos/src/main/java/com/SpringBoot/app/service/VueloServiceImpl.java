package com.SpringBoot.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringBoot.app.entity.Vuelo;
import com.SpringBoot.app.repository.VueloRepository;

/**
 * Clase vuelo service que implementa los métodos necesarios de la clase interface
 * @author Angelica Arroyave Duque
 *
 */
@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	private VueloRepository vueloRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Vuelo> findAll() {
		return vueloRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Vuelo> findAll(Pageable pageable) {
		return vueloRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vuelo> listVuelos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vuelo> listVuelosFecha(String fecha)  {
		Iterable<Vuelo> vuelos = vueloRepository.findAll();
		List<Vuelo> vuelosFecha = new ArrayList<>();
		
		for (int i = 0; i < ((List<Vuelo>) vuelos).size(); i++) {
			String fe = ((List<Vuelo>) vuelos).get(i).getFecha() + "";
			if(fe.split(" ")[0].equals(fecha)) {
				vuelosFecha.add(((List<Vuelo>) vuelos).get(i));
			}
		}
		
		return vuelosFecha;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vuelo> listVuelosRuta() {
		return null;
	}

	@Override
	@Transactional
	public Vuelo guardarVuelo(Vuelo vuelo) {
		return vueloRepository.save(vuelo);
	}

	@Override
	@Transactional
	public Vuelo actualizarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void eliminarVuelo(Long id) {
		vueloRepository.deleteById(id);
	}

	@Override
	public Optional<Vuelo> findById(Long id) {
		return vueloRepository.findById(id);
	}
}
