import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { ComicDTO } from '../dto/comic.dto';
import { AbstractService } from '../services/template.service';
import { Options } from 'selenium-webdriver/chrome';

/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar comic
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarComicService  {

  /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    
  }
  
  /**
   * @description Metodo encargado de invocar el servicio REST consultar comics
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public consultarComics(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST crear comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   * @param comicDTO contiene la informacion del comic a persistir
   */
  public crearComic(comicDTO : ComicDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/crear',comicDTO);
  }

  /**
   * @description Metodo encargado de invocar el servicio REST modificar comic
   * @author Andres Felipe Alarcon
   * @param comicDTO contiene la informacion del comic a persistir
   */
  public modificarComic(comicDTO : ComicDTO): Observable<any> {
    //return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar',{"idComic":comicDTO.id,"nombre":comicDTO.nombre});
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar', {
      params: new HttpParams().set('idComic', comicDTO.id).set('nombre',comicDTO.nombre)
  })
  }

  /**
   * @description Metodo encargado de invocar el servicio REST eliminar comic
   * @author Andres Felipe Alarcon
   * @param comicDTO contiene la informacion del comic a persistir
   */
  public eliminarComic(comicDTO : ComicDTO): Observable<any> {
    //return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/eliminar',{"idComic":comicDTO.id});
      console.log("Id en service: " + comicDTO.id);
      return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/eliminar', {
      params: new HttpParams().set('idComic', comicDTO.id)
  })
  }
}
