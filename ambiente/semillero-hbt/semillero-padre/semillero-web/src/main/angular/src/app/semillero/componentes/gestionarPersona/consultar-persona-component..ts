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
    selector: 'consultar-persona',
    templateUrl: './consultar-persona-component.html'
})
export class ConsultarPersonaComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public consultarPersonaForm : FormGroup;

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
        this.consultarPersonaForm = this.fb.group({
            id : [null, Validators.required],
            nombre : [null],
            identificacion : [null]
        });
        
    }
    ngOnInit(): void {
        this.persona = new PersonaDTO();
        this.listaPersonas = new Array<PersonaDTO>();
    }
   
    /**
     * Metodo que captura el click del boton y lo redirige al componente gestionar-comic
     */
    public regresar():void{
        this.router.navigateByUrl('/gestionar-persona');
    }
    public cargarDatosPersona(posicion : number) : void {
        let persona = this.listaPersonas[posicion];
        this.consultarPersonaForm.controls.id.setValue(persona.id);
        this.consultarPersonaForm.controls.nombre.setValue(persona.nombre);
        this.consultarPersonaForm.controls.numeroIdentificacion.setValue(persona.numeroIdentificacion);
        this.consultarPersonaForm.controls.id.disable();
        this.consultarPersonaForm.controls.nombre.disable();
        this.consultarPersonaForm.controls.numeroIdentificacion.disable();
//        this.gestionarComicForm.controls.color.enable(); para habilitar el campo

    }
   
    

}