package com.hbt.semillero.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina la entidad que permite representar la
 * tabla "TC_PERSONA"
 * 
 * @author Andrés Felipe Alarcón Fonseca
 * @version
 */
@Entity
@Table(name = "TC_PERSONA")
public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos necesarios para almacenar la informacion de la Persona
	 */
	private Long id;
	private String nombre;
	private Long numeroIdentificacion;
	
	/**
	 * Constructor vacio de la clase
	 */
	public Persona() {
		
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
	 * Metodo encargado de retornar el valor del atributo nombre
	 * 
	 * @return El nombre asociado a la clase
	 */
	@Column (name = "SCNOMBRE")
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * 
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo numeroIdentificacion
	 * 
	 * @return El numeroIdentificacion asociado a la clase
	 */
	@Column (name = "SCNUMIDENTIFICACION")
	public Long getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo numeroIdentificacion
	 * 
	 * @param numeroIdentificacion El nuevo numeroIdentificacion a modificar.
	 */
	public void setNumeroIdentificacion(Long numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", numeroIdentificacion=" + numeroIdentificacion + "]";
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
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroIdentificacion == null) ? 0 : numeroIdentificacion.hashCode());
		
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
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroIdentificacion == null) {
			if (other.numeroIdentificacion != null)
				return false;
		} else if (!numeroIdentificacion.equals(other.numeroIdentificacion))
			return false;
		return true;
	}
	
	
	
}
