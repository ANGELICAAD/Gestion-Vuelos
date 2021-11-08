package com.SpringBoot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.app.entity.Ruta;
import com.SpringBoot.app.service.RutaService;

/**
 * Clase ruta controler, se ejecutan todas las peticiones desde el postman
 * @author Angelica Arroyave Duque
 *
 */
@RestController
@RequestMapping("/api/rutas")
public class RutaController {
	
	@Autowired
	public RutaService rutaService;
	
	/**
	 * Método que lee y lista todas las rutas que hay en la base de datos
	 * Desde postman se realiza la petición: localhost:8080/api/rutas 
	 * @return las rutas ingresadas en la base de datos
	 */
	@GetMapping
	public ResponseEntity<?> read() {
		List<Ruta> rutas = (List<Ruta>) rutaService.findAll();
	
		if(rutas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(rutas);
	}
}
