import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { PersonaDTO } from '../dto/persona.dto';
import { AbstractService } from '../services/template.service';
import { Options } from 'selenium-webdriver/chrome';

/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar comic
 * @author Andrés Felipe Alarcón Fonseca
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarPersonaService  {

  /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    
  }
  
  /**
   * @description Metodo encargado de invocar el servicio REST consultar personas
   * @author Andrés Felipe Alarcón Fonseca
   */
  public consultarPersonas(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarPersona/consultarPersonas');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST crear persona
   * @author Andrés Felipe Alarcón Fonseca
   * @param personaDTO contiene la informacion de la persona a persistir
   */
  public crearPersona(personaDTO : PersonaDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarPersona/crearPersona',personaDTO);
  }

  /**
   * @description Metodo encargado de invocar el servicio REST modificar persona
   * @author Andres Felipe Alarcon
   * @param personaDTO contiene la informacion del comic a persistir
   */
  public modificarPersona(personaDTO : PersonaDTO): Observable<any> {
    //return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar',{"idComic":comicDTO.id,"nombre":comicDTO.nombre});
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarPersona/modificarPersona', {
      params: new HttpParams().set('idPersona', personaDTO.id).set('nombre',personaDTO.nombre)
  })
  }

  /**
   * @description Metodo encargado de invocar el servicio REST eliminar comic
   * @author Andres Felipe Alarcon
   * @param personaDTO contiene la informacion del comic a persistir
   */
  public eliminarPersona(personaDTO : PersonaDTO): Observable<any> {
    //return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/eliminar',{"idComic":comicDTO.id});
      //console.log("Id en service: " + personaDTO.id);
      return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarPersona/eliminar', {
      params: new HttpParams().set('idPersona', personaDTO.id)
  })
  }
}
