package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.hbt.semillero.entidades.EstadoProveedorEnum;

/**
 * @author Andrés Felipe Alarcón Fonseca
 */

public class ProveedorDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Identificador del proveedor o revista grafica
	 * */
	private String id;
	/**
	 * direccion del proveedor o revista grafica
	 * */
	private String direccion;
	/**
	 * fecha de creacion del proveedor
	 * */
	private LocalDate fechaCreacion;
	/**
	 * Atributo enum que almacena el estado del proveedor 
	 **/
	private EstadoProveedorEnum estado;
	/**
	 *  Atributo que hace referencia al id de persona, llave foranea 
	 **/
	private String idPersona;
	/**
	 *  Monto de credito del proveedor 
	 **/
	private Long montoCredito;

	/**
	 * Constructor de la clase.
	 */
	public ProveedorDTO() {
		
	}

	/**
	 * @param id
	 * @param direccion
	 * @param fechaCreacion
	 * @param estado
	 * @param idPersona
	 * @param montoCredito
	 */
	public ProveedorDTO(String id, String direccion, LocalDate fechaCreacion, EstadoProveedorEnum estado,
			String idPersona, Long montoCredito) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.idPersona = idPersona;
		this.montoCredito = montoCredito;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the fechaCreacion
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the estado
	 */
	public EstadoProveedorEnum getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoProveedorEnum estado) {
		this.estado = estado;
	}

	/**
	 * @return the idPersona
	 */
	public String getIdPersona() {
		return idPersona;
	}

	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * @return the montoCredito
	 */
	public Long getMontoCredito() {
		return montoCredito;
	}

	/**
	 * @param montoCredito the montoCredito to set
	 */
	public void setMontoCredito(Long montoCredito) {
		this.montoCredito = montoCredito;
	}
	
	
	
	
	
	
	
	
	
}
