import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { stringify } from 'querystring';

/**
 * Componente que se encargará de mostrar la información de un comic en específico
 */
@Component({
    selector: 'consultar-comic',
    templateUrl: './consultar-comic-component.html',
})

export class ConsultarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public consultarComicForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la informacion del comic a consultar, enviado desde gestionar-comic
     */
    public datos: any;
    /**
     * @description Este es el constructor del componente ConsultarComicComponent
     * @author Andres Felipe Alarcon Fonseca
     */
    constructor(private fb : FormBuilder,
        private router : Router, private activatedRoute: ActivatedRoute) {
        this.consultarComicForm = this.fb.group({
            nombre : [null, Validators.required],
            editorial : [null],
            tematica : [null],
            coleccion : [null],
            numeroPaginas : [null],
            precio : [null],
            autores : [null],
            color : [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Andres Felipe Alarcon Fonseca
     */
    ngOnInit(): void {
        
        this.comic = new ComicDTO();
        this.datos = this.activatedRoute.snapshot.params;
        //console.log("Datos recibidos en consultar" + JSON.stringify(this.datos));
        this.cargarDatosComic();

    }
    /**
     * Metodo que carga los datos recibidos a los campos de formulario, y posterior los desactiva, solo lectura
     */
    public cargarDatosComic () : void{
        this.consultarComicForm.controls.nombre.setValue(this.datos.nombre);
        this.consultarComicForm.controls.editorial.setValue(this.datos.editorial);
        this.consultarComicForm.controls.tematica.setValue(this.datos.tematica);
        this.consultarComicForm.controls.coleccion.setValue(this.datos.coleccion);
        this.consultarComicForm.controls.numeroPaginas.setValue(this.datos.numeroPaginas);
        this.consultarComicForm.controls.precio.setValue(this.datos.precio);
        this.consultarComicForm.controls.autores.setValue(this.datos.autores);
        this.consultarComicForm.controls.color.setValue(this.datos.color);
        this.consultarComicForm.controls.nombre.disable();
        this.consultarComicForm.controls.editorial.disable();
        this.consultarComicForm.controls.tematica.disable();
        this.consultarComicForm.controls.coleccion.disable();
        this.consultarComicForm.controls.numeroPaginas.disable();
        this.consultarComicForm.controls.precio.disable();
        this.consultarComicForm.controls.autores.disable();
        this.consultarComicForm.controls.color.disable();
    }
    /**
     * Metodo que captura el click del boton y lo redirige al componente gestionar-comic
     */
    public regresar():void{
        this.router.navigateByUrl('/gestionar-comic');
    }
    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Andres Felipe Alarcon Fonseca
     */
    get f() { 
        return this.consultarComicForm.controls;
    }
}    