package com.SpringBoot.app.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Clase correspondiente a la entidad ruta, la cual hace referencia a la misma tabla de la base de datos
 * @author Angelica Arroyave Duque
 *
 */
@Entity
@Table(name = "ruta")
@Inheritance(strategy = InheritanceType.JOINED)
public class Ruta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2740694285439769468L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRuta")
	private Long idRuta;
	
	@Column(nullable = false, name = "origen")
	private String origen;
	
	@Column(nullable = false, name = "destino")
	private String destino;
	
	@Column(nullable = false, name = "idAeropuerto")
	private int idAeropuerto;
	
	@ManyToOne
	@JoinColumn(name = "idVuelo", referencedColumnName = "idVuelo")
	private Vuelo idVuelo;

	public Long getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(Long idRuta) {
		this.idRuta = idRuta;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getIdAeropuerto() {
		return idAeropuerto;
	}

	public void setIdAeropuerto(int idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}

	public Vuelo getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Vuelo idVuelo) {
		this.idVuelo = idVuelo;
	}
}
