import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { ConsultarComicComponent } from './semillero/componentes/gestionarComic/consultar-comic-component';
import { GestionarPersonaComponent } from './semillero/componentes/gestionarPersona/gestionar-persona-component';
import { GestionarProveedorComponent } from './semillero/componentes/gestionarProveedor/gestionar-proveedor-component';
import { ConsultarProveedorComponent } from './semillero/componentes/gestionarProveedor/consultar-proveedor-component';
import { ConsultarPersonaComponent } from './semillero/componentes/gestionarPersona/consultar-persona-component.';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'consultar-comic', component: ConsultarComicComponent, data : null },
  { path: 'gestionar-persona', component: GestionarPersonaComponent, data : null },
  { path: 'gestionar-proveedor', component: GestionarProveedorComponent, data : null },
  { path: 'consultar-proveedor', component: ConsultarProveedorComponent, data : null },
  { path: 'consultar-proveedor', component: ConsultarPersonaComponent, data : null }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
