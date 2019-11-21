package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;
import com.hbt.semillero.ejb.IGestionarPersonaLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * una persona
 * 
 * @author Andrés Felipe Alarcón Fonseca
 * @version
 */
@Path("/GestionarPersona")
public class GestionarPersonaRest {
	
	/**
	 * Atributo que permite gestionar una persona
	 */
	@EJB
	private IGestionarPersonaLocal gestionarPersonaEJB;
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de una persona determianda
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersona/consultarPersona?idPersona=?
	 * 
	 * @param idPersona
	 * @return
	 */
	@GET
	@Path("/consultarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonaDTO consultarComic(@QueryParam("idPersona") Long idPersona) {
		if (idPersona != null) {
			PersonaDTO personaDTO = gestionarPersonaEJB.consultarPersona(idPersona.toString());
			return personaDTO;
		}
		return null;
	}
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersona() {
		return gestionarPersonaEJB.consultarPersonas();
	}
	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersona/crearPersona
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crearPersona")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO) {
		gestionarPersonaEJB.crearPersona(personaDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Persona creada exitosamente");
		return resultadoDTO;
	}

	/**
	 * 
	 * Metodo encargado de modificar el nombre de una persona
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar?idComic=1&nombre=nuevonombre
	 * @param idPersona identificador de la persona a buscar
	 * @param nombre nombre nuevo de la persona
	 */
	@GET
	@Path("/modificarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public void modificarPersona(@QueryParam("idPersona") Long idPersona, @QueryParam("nombre") String nombre) {
		gestionarPersonaEJB.modificarPersona(idPersona, nombre, null);
	}

	/**
	 * 
	 * Metodo encargado de eliminar una persona dado el id
	 * 
	 * @param idPersona identificador del comic
	 */
	@GET
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminarPersona(@QueryParam("idPersona") Long idPersona) {
		
		if (idPersona != null) {
			//System.out.println("Entra al if de eliminar");
			gestionarPersonaEJB.eliminarPersona(idPersona);

		}
	}
}
