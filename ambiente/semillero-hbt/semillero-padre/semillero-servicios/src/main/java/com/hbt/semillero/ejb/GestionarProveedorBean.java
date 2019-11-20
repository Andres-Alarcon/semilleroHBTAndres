package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoProveedorEnum;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Proveedor;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los proveedores
 * 
 * @author Andrés Felipe Alarcón Fonseca 
 * @version
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarProveedorBean implements IGestionarProveedorLocal{
	
	
	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearProveedor(ProveedorDTO proveedorNuevo) {
		// TODO Auto-generated method stub
		// Entidad nueva
		Proveedor proveedor = convertirProveedorDTOToProveedor(proveedorNuevo);
		// Se almacena la informacion y se maneja la enidad comic
		List<Proveedor> resultados = em.createQuery("SELECT COUNT(p) FROM TC_PROVEEDORES p").getResultList();
			
			if (resultados.size() <= 30) {
				em.persist(proveedor);
		}
			else {
				
			}
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarProveedor(Long id, String nombre, Long monto, ProveedorDTO proveedorNuevo, PersonaDTO personaNueva) {
		// TODO Auto-generated method stub
		Proveedor proveedorModificar ;
		Persona personaModificar;
		if(proveedorNuevo==null) {
			// Entidad a modificar, en proveedor el monto y en persona el nombre
			proveedorModificar = em.find(Proveedor.class, id);
			personaModificar = em.find(Persona.class, proveedorModificar.getIdPersona());
		}else {
			proveedorModificar = convertirProveedorDTOToProveedor(proveedorNuevo);
			personaModificar = convertirPersonaDTOToPersona(personaNueva);
		}
		proveedorModificar.setMontoCredito(monto);
		personaModificar.setNombre(nombre);
		em.merge(personaModificar);
		em.merge(proveedorModificar);
	}
	/***
	 * Metodo que en vez de eliminar el proveedor, cambia su estado	
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarProveedor(Long idProveedor) {
		// TODO Auto-generated method stub
		Proveedor proveedorEliminar = em.find(Proveedor.class, idProveedor);
		if (proveedorEliminar != null) {
			proveedorEliminar.setEstadoProvEnum(EstadoProveedorEnum.INACTIVO);
			em.merge(proveedorEliminar);
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ProveedorDTO consultarProveedor(String idProveedor) {
		// TODO Auto-generated method stub
		//EntityTransaction tx = em.getTransaction();
		//try {
			//tx.begin();
			Proveedor proveedor = null;
			proveedor = new Proveedor();
			proveedor = em.find(Proveedor.class, Long.parseLong(idProveedor));
			ProveedorDTO proveedorDTO = convertirProveedorToProveedorDTO(proveedor);
			//tx.commit();
			return proveedorDTO;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			//tx.rollback();
//			}
//		return null;
	}

	@Override
	public List<ProveedorDTO> consultarProveedores() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param proveedor
	 * @return
	 */
	private ProveedorDTO convertirProveedorToProveedorDTO(Proveedor proveedor) {
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		if(proveedor.getId()!=null) {
			proveedorDTO.setId(proveedor.getId().toString());
		}
		proveedorDTO.setDireccion(proveedor.getDireccion());
		proveedorDTO.setFechaCreacion(proveedor.getFechaCreacion());
		proveedorDTO.setEstado(proveedor.getEstadoProvEnum());
		proveedorDTO.setIdPersona(proveedor.getIdPersona().toString());
		proveedorDTO.setMontoCredito(proveedor.getMontoCredito());
		return proveedorDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un proveedorDTO a un proveedor
	 * 
	 * @param proveedor
	 * @return
	 */
	private Proveedor convertirProveedorDTOToProveedor(ProveedorDTO proveedorDTO) {
		Proveedor proveedor = new Proveedor();
		if(proveedorDTO.getId()!=null) {
			proveedor.setId(Long.parseLong(proveedorDTO.getId()));
		}
		
		proveedor.setDireccion(proveedorDTO.getDireccion());
		proveedor.setFechaCreacion(proveedorDTO.getFechaCreacion());
		proveedor.setEstadoProvEnum(proveedorDTO.getEstado());
		proveedor.setIdPersona(Long.valueOf(proveedorDTO.getIdPersona()));
		proveedor.setMontoCredito(proveedorDTO.getMontoCredito());
		return proveedor;
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
