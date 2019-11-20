package com.hbt.semillero.dto;

import java.io.Serializable;

public class PersonaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identificador unico de la persona
	 */
	private String id;
	/**
	 * Nombre de la persona
	 */
	private String nombre;
	/**
	 * Numero de identificacion de la persona
	 */
	private String numeroIdentificacion;

	public PersonaDTO() {
		
	}

	/**
	 * @param id
	 * @param nombre
	 * @param numeroIdentificacion
	 */
	public PersonaDTO(String id, String nombre, String numeroIdentificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * @param numeroIdentificacion the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	
	
	
}
