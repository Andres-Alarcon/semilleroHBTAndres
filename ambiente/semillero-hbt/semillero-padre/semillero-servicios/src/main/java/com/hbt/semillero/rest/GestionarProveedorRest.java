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

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
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
	/**
	 * Crea los proveedores en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersona/crearProveedor
	 * @param proveedorDTO
	 * @return
	 */
	@POST
	@Path("/crearProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO) {
		gestionarProveedorEJB.crearProveedor(proveedorDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Proveedor creado exitosamente");
		return resultadoDTO;
	}

	/**
	 * 
	 * Metodo encargado de modificar el monto de un proveedor
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar?idComic=1&nombre=nuevonombre
	 * @param idProveedor identificador del proveedor a buscar
	 * @param monto monto nuevo del proveedor
	 */
	@GET
	@Path("/modificarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public void modificarProveedor(@QueryParam("idProveedor") Long idProveedor, @QueryParam("monto") Long monto) {
		
		gestionarProveedorEJB.modificarProveedor(idProveedor, "", monto, null, null);
	}

	/**
	 * 
	 * Metodo encargado de cambiar de estado a un proveedor
	 * 
	 * @param idProveedor identificador del proveedor
	 */
	@GET
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminarProveedor(@QueryParam("idProveedor") Long idProveedor) {
		
		if (idProveedor != null) {
			//System.out.println("Entra al if de eliminar");
			gestionarProveedorEJB.eliminarProveedor(idProveedor);

		}
	}
}
