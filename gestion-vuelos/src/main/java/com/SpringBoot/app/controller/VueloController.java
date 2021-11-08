package com.SpringBoot.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.app.entity.Vuelo;
import com.SpringBoot.app.service.VueloService;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

	@Autowired
	public VueloService vueloService;
	
	/**
	 * Método encargado de crear un vuelo con los datos ingresados en la petición como json
	 * Desde postman se usa: localhost:8080/api/vuelos
	 * @param vuelo datos del vuelo a guardar
	 * @return mensaje de respuesta
	 */
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Vuelo vuelo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vueloService.guardarVuelo(vuelo));
	}
	
	/**
	 * Método encargado de listar todos los vuelos guardados en la base de datos
	 * Desde postman se usa: localhost:8080/api/vuelos/ 
	 * @return todos los vuelos de la base de datos
	 */
	@GetMapping("/")
	public ResponseEntity<?> read() {
		List<Vuelo> vuelos = (List<Vuelo>) vueloService.findAll();
		
		if(vuelos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(vuelos);		
	}
	
	/**
	 * Método encargado de buscar los vuelos correspondientes a una fecha
	 * Desde postman se usa: localhost:8080/api/vuelos/fechaV?fechaVu=2021-11-05 
	 * NOTA: Como con el Query no funcionó se hizo de la manera convencional, sin embargo, sigo
	 * en búsqueda de la manera adecuada para implementar los query directamente en la base de datos
	 * @param fecha datos ingresado como value a buscar
	 * @return los vuelos con fecha especificada
	 */
	@GetMapping("/{fechaV}")
	public ResponseEntity<?> readDate(@RequestParam("fechaVu") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") String fecha){
		List<Vuelo> vuelos = (List<Vuelo>) vueloService.listVuelosFecha(fecha);
		
		if(!vuelos.isEmpty()) {
			return ResponseEntity.ok(vuelos);
		}
		
		return ResponseEntity.notFound().build();		
	}
	
	/**
	 * Método encargado de mostrar las rutas de acuerdo a un vuelo
	 * NOTA: El query realizado no funcionó, lo intenté desde el vueloRepository, tampoco funcionó de manera
	 * que lo deje desde donde comencé
	 * Desde postman se usa: localhost:8080/api/vuelos/listRuta 
	 * @return todas las rutas correspondientes a un vuelo
	 */
	@GetMapping("/listRuta")
	public ResponseEntity<?> readRuta(){
		List<Vuelo> vuelos = (List<Vuelo>) vueloService.listVuelosRuta();
		
		if(vuelos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(vuelos);
	}
	
	/**
	 * Método encargado de actualizar la información de un vuelo en específico
	 * Desde postman se usa: localhost:8080/api/vuelos/2
	 * @param vueloDetalle información de los datos a cambiar
	 * @param idVuelo id del vuelo a modificar información
	 * @return respuesta de proceso correcto o no
	 */
	@PutMapping("/{idVuelo}")
	public ResponseEntity<?> update (@RequestBody Vuelo vueloDetalle, @PathVariable Long idVuelo) {
		Optional<Vuelo> vuelo = vueloService.findById(idVuelo);
		
		if(!vuelo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		vuelo.get().setNumeroVuelo(vueloDetalle.getNumeroVuelo());
		vuelo.get().setFecha(vueloDetalle.getFecha());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vueloService.guardarVuelo(vuelo.get()));
	}
	
	/**
	 * Método encargado de eliminar un bueno especifico
	 * Desde postman se usa: localhost:8080/api/vuelos/eliminar/6
	 * @param idVuelo id del vuelo a eliminar
	 * @return si la acción se dio de forma correcta o no
	 */
	@DeleteMapping("/eliminar/{idVuelo}")
	public ResponseEntity<?> delete (@PathVariable Long idVuelo) {
		Optional<Vuelo> vuelo = vueloService.findById(idVuelo);
		
		if(!vuelo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		vueloService.eliminarVuelo(idVuelo);
		return ResponseEntity.ok().build();
	}
}
