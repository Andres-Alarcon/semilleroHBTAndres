import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { ProveedorDTO } from '../dto/proveedor.dto';
import { AbstractService } from '../services/template.service';
import { Options } from 'selenium-webdriver/chrome';

/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar comic
 * @author Andrés Felipe Alarcón Fonseca
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarProveedorService  {

  /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    
  }
  
  /**
   * @description Metodo encargado de invocar el servicio REST consultar proveedores
   * @author Andrés Felipe Alarcón Fonseca
   */
  public consultarProveedores(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedores');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST crear proveedor
   * @author Andrés Felipe Alarcón Fonseca
   * @param proveedorDTO contiene la informacion de la persona a persistir
   */
  public crearProveedor(proveedorDTO : ProveedorDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crearProveedor',proveedorDTO);
  }

  /**
   * @description Metodo encargado de invocar el servicio REST modificar proveedor
   * @author Andres Felipe Alarcon
   * @param proveedorDTO contiene la informacion del proveedor a persistir
   */
  public modificarProveedor(proveedorDTO : ProveedorDTO): Observable<any> {
    //return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar',{"idComic":comicDTO.id,"nombre":comicDTO.nombre});
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/modificarProveedor', {
      params: new HttpParams().set('idProveedor', proveedorDTO.id).set('monto',proveedorDTO.montoCredito.toString())
  })
  }

  /**
   * @description Metodo encargado de invocar el servicio REST eliminar proveedor
   * @author Andres Felipe Alarcon
   * @param proveedorDTO contiene la informacion del proveedor a persistir
   */
  public eliminarProveedor(proveedorDTO : ProveedorDTO): Observable<any> {
    //return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/eliminar',{"idComic":comicDTO.id});
      //console.log("Id en service: " + personaDTO.id);
      return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/eliminar', {
      params: new HttpParams().set('idProveedor', proveedorDTO.id)
  })
  }
}
