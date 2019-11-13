package com.hbt.semillero.rest;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
/**
 * <b>Descripcion: Utilizamos gestionar comic bean con el mundo extterior
 * */
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
@Path ("/GestionarComic/")
public class GestionarComicRest {
	@EJB
	private IGestionarComicLocal gestionarComicEJB;
	
	/*
	 * Es importante decirle cual verbo http vamos a usar
	 * */
	@GET //tipo de verbo http
	@Path("/saludo") // ruta de acceso unica para nuestro recurso 
	@Produces// define el tipo de recurso que se va a producir
	public String primerRest() {
		return "Hola Mundo";
	}
	//servicio que vaya y consulte el comic
	@GET
    @Path("/consultarComic")
    @Produces(MediaType.APPLICATION_JSON)
	//para especificar que recibe un paramentro dentro de la URL Qqueryparam
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if(idComic!=null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
			
		}
		return null;
	}
	
	@POST
	@Path("/crearComic")
//	public void crearComic(@QueryParam("idComic") Long idComic, @QueryParam("nombre") String nombre, @QueryParam("editorial") String editorial,
//							@QueryParam("tematica") String tematica, @QueryParam("coleccion") String coleccion, @QueryParam("numeroPaginas") Integer numeroPaginas,
//							@QueryParam("precio") BigDecimal precio, @QueryParam("autores") String autores, @QueryParam("color") Boolean color,
//							@QueryParam("fecha") String fecha, @QueryParam("estado") String estado, @QueryParam("cantidad") Long cantidad ) {
	public void crearComic() {
		System.out.println("Entra al metodo");
		ComicDTO comicNuevo = new ComicDTO();
//		comicNuevo.setId(idComic.toString());
//		comicNuevo.setNombre(nombre);
//		comicNuevo.setEditorial(editorial);
//		comicNuevo.setTematica(TematicaEnum.CIENCIA_FICCION);
//		comicNuevo.setColeccion(coleccion);
//		comicNuevo.setNumeroPaginas(numeroPaginas);
//		comicNuevo.setPrecio(precio);
//		comicNuevo.setAutores(autores);
//		comicNuevo.setColor(color);
//		comicNuevo.setFechaVenta(LocalDate.now());
//		comicNuevo.setEstado(EstadoEnum.ACTIVO);
//		comicNuevo.setCantidad(cantidad);
		comicNuevo.setId("");
		comicNuevo.setNombre("Comic Prueba");
		comicNuevo.setEditorial("La Pruebita");
		comicNuevo.setTematica(TematicaEnum.CIENCIA_FICCION);
		comicNuevo.setColeccion("De Prueba");
		comicNuevo.setNumeroPaginas(350);
		comicNuevo.setPrecio(new BigDecimal(7500));
		comicNuevo.setAutores("Andres");
		comicNuevo.setColor(true);
		comicNuevo.setFechaVenta(LocalDate.now());
		comicNuevo.setEstado(EstadoEnum.ACTIVO);
		comicNuevo.setCantidad(12L);
		gestionarComicEJB.crearComic(comicNuevo);
		
	}
	
}
