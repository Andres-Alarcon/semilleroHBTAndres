import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule} from '@angular/http';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { APP_BASE_HREF } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { MenuComponent } from './semillero/componentes/menu/menu-component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { CrearPersonaComponent } from './semillero/componentes/crearPersona/crear-persona-component';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { ConsultarComicComponent } from './semillero/componentes/gestionarComic/consultar-comic-component';
import { GestionarPersonaComponent } from './semillero/componentes/gestionarPersona/gestionar-persona-component';
import { GestionarProveedorComponent } from './semillero/componentes/gestionarProveedor/gestionar-proveedor-component';
import { ConsultarProveedorComponent } from './semillero/componentes/gestionarProveedor/consultar-proveedor-component';

// DTOs
export { ComicDTO } from './semillero/dto/comic.dto';
export { ResultadoDTO } from './semillero/dto/resultado.dto';
export { PersonaDTO } from './semillero/dto/persona.dto';
export { ProveedorDTO } from './semillero/dto/proveedor.dto';

//Manejo de servicios

import {EjemploService} from './semillero/services/ejemplo.service';
import {AbstractService} from './semillero/services/template.service';
import { ConsultarPersonaComponent } from './semillero/componentes/gestionarPersona/consultar-persona-component.';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    BienvenidaComponent,
    CrearPersonaComponent,
    GestionarComicComponent,
    ConsultarComicComponent,
    GestionarPersonaComponent,
    GestionarProveedorComponent,
    ConsultarProveedorComponent,
    ConsultarPersonaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
  	{ provide: APP_BASE_HREF, useValue: '/SemilleroHBT' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { 

}
