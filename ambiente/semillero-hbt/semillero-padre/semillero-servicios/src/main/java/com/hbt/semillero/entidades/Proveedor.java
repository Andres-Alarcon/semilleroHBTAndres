package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina la entidad que permite representar la
 * tabla "TC_PROVEEDOR"
 * 
 * @author Andrés Felipe Alarcón Fonseca
 * @version
 */
@Entity
@Table(name = "TC_PROVEEDOR")

public class Proveedor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributos necesarios para almacenar la informacion del Proveedor
	 */
	private Long id;
	private String direccion;
	private LocalDate fechaCreacion;
	private EstadoProveedorEnum estadoProvEnum;
	private Long idPersona;
	private Long montoCredito;
	
	/**
	 * Constructor vacio de la clase
	 */
	public Proveedor() {
		
	}
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SPID")
	public Long getId() {
		return id;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * 
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo direccion
	 * 
	 * @return La direccion asociada a la clase
	 */
	@Column(name = "SPDIRECCION")
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo direccion
	 * 
	 * @param direccion la nueva direccion a modificar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * 
	 * @return La fechaCreacion asociada a la clase
	 */
	@Column(name = "SPFECHA_CREACION")
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * 
	 * @param fechaCreacion la nueva fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estadoProvEnum
	 * 
	 * @return El estadoProvEnum asociado a la clase
	 */
	@Column(name = "SPESTADO")
	public EstadoProveedorEnum getEstadoProvEnum() {
		return estadoProvEnum;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estadoProvEnum
	 * 
	 * @param estadoProvEnum el nuevo estadoProvEnum a modificar.
	 */
	public void setEstadoProvEnum(EstadoProveedorEnum estadoProvEnum) {
		this.estadoProvEnum = estadoProvEnum;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo idPersona
	 * 
	 * @return El idPersona asociado a la clase
	 */
	@Column(name = "SPIDPERSONA")
	public Long getIdPersona() {
		return idPersona;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo idPersona
	 * 
	 * @param idPersona el nuevo idPersona a modificar.
	 */
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo montoCredito
	 * 
	 * @return El montoCredito asociado a la clase
	 */
	@Column(name = "SPMONTO_CREDITO")
	public Long getMontoCredito() {
		return montoCredito;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo montoCredito
	 * 
	 * @param montoCredito el nuevo montoCredito a modificar.
	 */
	public void setMontoCredito(Long montoCredito) {
		this.montoCredito = montoCredito;
	}
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", direccion=" + direccion + ", fechaCreacion=" + fechaCreacion
				+ ", estadoProvEnum=" + estadoProvEnum + ", idPersona=" + idPersona + ", montoCredito=" + montoCredito
				+ "]";
	}
	/**
	 * @see java.lang.Object#hashCode() Este método viene a complementar al método
	 *      equals y sirve para comparar objetos de una forma más rápida en
	 *      estructuras Hash ya que únicamente nos devuelve un número entero. Cuando
	 *      Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet
	 *      etc) primero invoca al método hashcode y luego el equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((estadoProvEnum == null) ? 0 : estadoProvEnum.hashCode());
		result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
		result = prime * result + ((montoCredito == null) ? 0 : montoCredito.hashCode());
		return result;
	}
	/**
	 * @see java.lang.Object#equals(java.lang.Object) Metodo que permite comparar
	 *      objetos
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (estadoProvEnum == null) {
			if (other.estadoProvEnum != null)
				return false;
		} else if (!estadoProvEnum.equals(other.estadoProvEnum))
			return false;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		if (montoCredito == null) {
			if (other.montoCredito != null)
				return false;
		} else if (!montoCredito.equals(other.montoCredito))
			return false;
		return true;
	}
	
}
