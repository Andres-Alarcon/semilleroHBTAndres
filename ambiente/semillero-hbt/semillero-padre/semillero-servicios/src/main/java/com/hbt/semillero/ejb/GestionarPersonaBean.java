package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.Persona;
/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * las personas
 * 
 * @author Andrés Felipe Alarcón Fonseca
 * @version
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarPersonaBean implements IGestionarPersonaLocal{

	
	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void crearPersona(PersonaDTO personaNueva) {
		// TODO Auto-generated method stub
		// Entidad nueva
				Persona persona = convertirPersonaDTOToPersona(personaNueva);
				// Se almacena la informacion y se maneja la enidad comic
				em.persist(persona);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarPersona(Long id, String nombre, PersonaDTO personaNueva) {
		// TODO Auto-generated method stub
		Persona personaModificar ;
		if(personaNueva==null) {
			// Entidad a modificar
			personaModificar = em.find(Persona.class, id);
		}else {
			personaModificar = convertirPersonaDTOToPersona(personaNueva);
		}
		personaModificar.setNombre(nombre);
		em.merge(personaModificar);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarPersona(Long idPersona) {
		// TODO Auto-generated method stub
		Persona personaEliminar = em.find(Persona.class, idPersona);
		if (personaEliminar != null) {
			em.remove(personaEliminar);
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonaDTO consultarPersona(String idPersona) {
		// TODO Auto-generated method stub
		Persona persona = null;
		persona = new Persona();
		persona = em.find(Persona.class, Long.parseLong(idPersona));
		PersonaDTO personaDTO = convertirPersonaToPersonaDTO(persona);
		return personaDTO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PersonaDTO> consultarPersonas() {
		List<PersonaDTO> resultadosPersonaDTO = new ArrayList<PersonaDTO>();
		List<Persona> resultados = em.createQuery("select p from Persona p").getResultList();
		for (Persona persona:resultados) {
			resultadosPersonaDTO.add(convertirPersonaToPersonaDTO(persona));
		}
		return resultadosPersonaDTO;
	}
	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param comic
	 * @return
	 */
	private PersonaDTO convertirPersonaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		if(persona.getId()!=null) {
		 personaDTO.setId(persona.getId().toString());
		}
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion().toString());
		return personaDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un comicDTO a un comic
	 * 
	 * @param comic
	 * @return
	 */
	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		if(personaDTO.getId()!=null) {
			persona.setId(Long.parseLong(personaDTO.getId()));
		}
		persona.setNombre(personaDTO.getNombre());
		persona.setNumeroIdentificacion(Long.valueOf(personaDTO.getNumeroIdentificacion()));
		return persona;
	}

}
