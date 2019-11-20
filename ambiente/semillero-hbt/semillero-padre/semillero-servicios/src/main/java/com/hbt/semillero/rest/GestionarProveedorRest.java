package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.ejb.IGestionarProveedorLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * un proveedor
 * 
 * @author Andrés Felipe Alarcón Fonseca
 * @version
 */
@Path("/GestionarProveedor")
public class GestionarProveedorRest {

	@EJB
	private IGestionarProveedorLocal gestionarProveedorEJB;
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de una persona determianda
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedor?idProveedor=?
	 * 
	 * @param idProveedor
	 * @return
	 */
	@GET
	@Path("/consultarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public ProveedorDTO consultarProveedor(@QueryParam("idProveedor") Long idProveedor) {
		if (idProveedor != null) {
			ProveedorDTO proveedorDTO = gestionarProveedorEJB.consultarProveedor(idProveedor.toString());
			return proveedorDTO;
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
	@Path("/consultarProveedores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProveedorDTO> consultarProveedor() {
		return gestionarProveedorEJB.consultarProveedores();
	}
}
