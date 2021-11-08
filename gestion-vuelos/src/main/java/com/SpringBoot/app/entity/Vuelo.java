package com.SpringBoot.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Clase correspondiente a la entidad vuelo, la cual hace referencia a la misma tabla de la base de datos
 * @author Angelica Arroyave Duque
 *
 */
@Entity
@Table(name = "vuelo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vuelo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4761706577561607154L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVuelo")
	private Long idVuelo;
	
	@Column(nullable = false, name = "numeroVuelo")
	private int numeroVuelo;
	
	@Column(nullable = false, name = "fecha")
	@DateTimeFormat(pattern = "%Y-%m-%d")
	private Date fecha;
	
	@Column(nullable = false, name = "idAvion")
	private int idAvion;
	
	public Long getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Long idVuelo) {
		this.idVuelo = idVuelo;
	}

	public int getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}
}
