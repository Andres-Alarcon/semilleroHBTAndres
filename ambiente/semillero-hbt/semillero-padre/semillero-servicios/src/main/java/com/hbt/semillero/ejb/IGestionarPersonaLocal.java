package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;

/**
 * Expone los métodos del EJB GestionarComic Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * 
 * @author Andrés Felipe Alarcón Fonseca
 *
 */
@Local
public interface IGestionarPersonaLocal {
	/**
	 * 
	 * Metodo encargado de crear un comic y persistirlo
	 * 
	 * @author Andrés Felipe Alarcón Fonseca
	 * 
	 * @param personaNueva informacion nueva a crear
	 */
	public void crearPersona(PersonaDTO personaNueva);

	/**
	 * 
	 * Metodo encargado de consultar un comic modificarlo y guardarlo
	 * 
	 * @author Andrés Felipe Alarcón Fonseca
	 * 
	 * @param comicModificar informacion nueva a modificar
	 */
	public void modificarPersona(Long id, String nombre, PersonaDTO personaNueva);

	/**
	 * 
	 * Metodo encargado de eliminar un comic modificarlo y guardarlo
	 * 
	 * @author Andrés Felipe Alarcón Fonseca
	 * 
	 * @param comicEliminar informacion a eliminar
	 */
	public void eliminarPersona(Long idPersona);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un comic
	 * 
	 * @param idComic identificador del comic a ser consultado
	 * @return comic Resultado de la consulta
	 * @throws Exception si no se recibe idComic
	 */
	public PersonaDTO consultarPersona(String idPersona);

	/**
	 * 
	 * Metodo encargado de retornar una lista de comics
	 * 
	 * @return
	 */
	public List<PersonaDTO> consultarPersonas();
}
