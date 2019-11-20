package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;


/**
 * Expone los métodos del EJB GestionarComic Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author Andrés Felipe Alarcón Fonseca
 *
 */
@Local
public interface IGestionarProveedorLocal {
	/**
	 * 
	 * Metodo encargado de crear un proveedor y persistirlo
	 * 
	 * @author Andrés Felipe Alarcón Fonseca
	 * 
	 * @param proveedorNuevo informacion nueva a crear
	 */
	public void crearProveedor(ProveedorDTO proveedorNuevo);

	/**
	 * 
	 * Metodo encargado de consultar un provedor modificarlo y guardarlo
	 * 
	 * @author Andrés Felipe Alarcón Fonseca
	 * 
	 * @param personaNueva informacion nueva a modificar
	 */
	public void modificarProveedor(Long id, String nombre, Long monto,ProveedorDTO proveedorNuevo, PersonaDTO personaDTO);

	/**
	 * 
	 * Metodo encargado de eliminar un proveedor modificarlo y guardarlo
	 * 
	 * @author Andrés Felipe Alarcón Fonseca
	 * 
	 * @param idPersona id de proveedor a eliminar
	 */
	public void eliminarProveedor(Long idProveedor);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un proveedor
	 * 
	 * @param idProveedor identificador del proveedor a ser consultado
	 */
	public ProveedorDTO consultarProveedor(String idProveedor);

	/**
	 * 
	 * Metodo encargado de retornar una lista de comics
	 * 
	 * @return
	 */
	public List<ProveedorDTO> consultarProveedores();
}
