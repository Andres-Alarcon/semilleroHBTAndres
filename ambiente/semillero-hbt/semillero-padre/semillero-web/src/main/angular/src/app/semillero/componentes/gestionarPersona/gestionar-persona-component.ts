import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarPersonaService } from '../../services/gestionar.persona.service';
import { PersonaDTO } from '../../dto/persona.dto';

/**
 * @description Componenete gestionar persona, el cual contiene la logica CRUD
 * 
 * @author Andrés Felipe Alarcón Fonseca
 */
@Component({
    selector: 'gestionar-persona',
    templateUrl: './gestionar-persona-component.html'
})
export class GestionarPersonaComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarPersonaForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public persona: PersonaDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaPersonas : Array<PersonaDTO>;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    public idPersona : number = 0;

    /**
     * @description Este es el constructor del componente GestionarPersonaComponent
     * @author Andrés Felipe Alarcón Fonseca
     */
    constructor(private fb : FormBuilder,
        private router : Router,
        private gestionarPersonaService : GestionarPersonaService) {
        this.gestionarPersonaForm = this.fb.group({
            id : [null, Validators.required],
            nombre : [null],
            identificacion : [null]
        });
        
    }
    ngOnInit(): void {
        this.persona = new PersonaDTO();
        this.listaPersonas = new Array<PersonaDTO>();
        this.consultarPersonas();
        console.log("onInit de Personas: " + this.consultarPersonas.length);
    }
    /**
     * @description Metodo encargado de consultar las personas existentes
     * @author Andrés Felipe Alarcón Fonseca
     */
    public consultarPersonas() : void {
        this.gestionarPersonaService.consultarPersonas().subscribe(listaPersonas => {
            this.listaPersonas = listaPersonas;
        }, error => {
            console.log(error);
        });
        console.log("En consultarPersonas: " + this.listaPersonas.length);
    }

        /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearPersona() : void {
        this.submitted = true;
        if(this.gestionarPersonaForm.invalid) {
            return;
        }
        
        this.persona = new PersonaDTO();
        this.persona.id = this.gestionarPersonaForm.controls.id.value;
        this.persona.nombre = this.gestionarPersonaForm.controls.nombre.value;
        this.persona.numeroIdentificacion = this.gestionarPersonaForm.controls.identificacion.value;
  
        this.gestionarPersonaService.crearPersona(this.persona).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarPersonas();
                this.limpiarFormulario();
            }
        }, error => {
            console.log(error);
        });
    }
    public consultarPersona(posicion : number) : void {
        let persona = this.listaPersonas[posicion];
        this.gestionarPersonaForm.controls.id.setValue(persona.id);
        this.gestionarPersonaForm.controls.nombre.setValue(persona.nombre);
        this.gestionarPersonaForm.controls.numeroIdentificacion.setValue(persona.numeroIdentificacion);
        this.gestionarPersonaForm.controls.id.disable();
        this.gestionarPersonaForm.controls.nombre.disable();
        this.gestionarPersonaForm.controls.numeroIdentificacion.disable();
//        this.gestionarComicForm.controls.color.enable(); para habilitar el campo

    }
    public cargarDatosPersona(posicion : number) : void {

        let persona = this.listaPersonas[posicion];
        this.gestionarPersonaForm.controls.id.setValue(persona.id);
        this.gestionarPersonaForm.controls.nombre.setValue(persona.nombre);
        this.gestionarPersonaForm.controls.numeroIdentificacion.setValue(persona.numeroIdentificacion);
    
        //this.listaComics = this.listaComics.filter(comic => comic !== comic);
        //this.idComic--;
        this.idPersona = posicion;
        this.gestionarPersonaForm.controls.crear.disable();
    //        this.gestionarComicForm.controls.color.enable(); para habilitar el campo
    
    }
    public editarPersona() : void {
        
        //this.listaComics = this.listaComics.filter(comic => comic !== comic);
        //this.idComic--;
        let persona = this.listaPersonas[this.idPersona];

        this.persona.id = persona.id;
        this.persona.nombre = this.gestionarPersonaForm.controls.nombre.value;
        /*this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;
        this.comic.cantidad = 12;*/

        this.gestionarPersonaService.modificarPersona(this.persona).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarPersonas();
                this.limpiarFormulario();
            }
        }, error => {
            console.log(error);
        });
//        this.gestionarComicForm.controls.color.enable(); para habilitar el campo

    }
    /**
     * Metodo que borra directamente el comic de la tabla
     */
    public borrarPersona(posicion: number):void{
        let persona = this.listaPersonas[posicion];
        //this.listaComics = this.listaComics.filter(comic => comic !== comic);
        //this.idComic--;
        this.gestionarPersonaService.eliminarPersona(persona).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarPersonas();
                this.limpiarFormulario();
            }
        }, error => {
            console.log(error);
        });
    }
    private limpiarFormulario() : void {
        this.submitted = false;
        this.gestionarPersonaForm.controls.id.setValue(null);
        this.gestionarPersonaForm.controls.nombre.setValue(null);
        this.gestionarPersonaForm.controls.identificacion.setValue(null);
    }

}