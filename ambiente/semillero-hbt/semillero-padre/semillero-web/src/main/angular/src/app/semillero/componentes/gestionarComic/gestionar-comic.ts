
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarComicService } from '../../services/gestionar.comic.service';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics : Array<ComicDTO>;

    public idComic : number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb : FormBuilder,
        private router : Router,
        private gestionarComicService : GestionarComicService) {
        this.gestionarComicForm = this.fb.group({
            nombre : [null, Validators.required],
            editorial : [null],
            tematica : [null],
            coleccion : [null],
            numeroPaginas : [null],
            precio : [null],
            autores : [null],
            color : [null],
            crear : [null],
            editar: [null]
        });
        
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
        this.consultarComics();
    }
    /**
     * @description Metodo encargado de consultar los comics existentes
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    public consultarComics() : void {
        this.gestionarComicService.consultarComics().subscribe(listaComics => {
            this.listaComics = listaComics;
        }, error => {
            console.log(error);
        });
    }
   
    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarComic() : void {
        this.submitted = true;
        if(this.gestionarComicForm.invalid) {
            return;
        }
        
        this.comic = new ComicDTO();
        this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
        this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;
        this.comic.cantidad = 12;
  
        this.gestionarComicService.crearComic(this.comic).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarComics();
                this.limpiarFormulario();
            }
        }, error => {
            console.log(error);
        });
    }

    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public consultarComic(posicion : number) : void {
        let comic = this.listaComics[posicion];
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        this.gestionarComicForm.controls.nombre.disable();
        this.gestionarComicForm.controls.editorial.disable();
        this.gestionarComicForm.controls.tematica.disable();
        this.gestionarComicForm.controls.coleccion.disable();
        this.gestionarComicForm.controls.numeroPaginas.disable();
        this.gestionarComicForm.controls.precio.disable();
        this.gestionarComicForm.controls.autores.disable();
        this.gestionarComicForm.controls.color.disable();
//        this.gestionarComicForm.controls.color.enable(); para habilitar el campo

    }
    /*
    public editarComic(comic : any) : void {
        this.router.navigate(['bienvenida',comic]);
    }
    */
   public cargarDatosComic(posicion : number) : void {

    let comic = this.listaComics[posicion];
    this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
    this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
    this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
    this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
    this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
    this.gestionarComicForm.controls.precio.setValue(comic.precio);
    this.gestionarComicForm.controls.autores.setValue(comic.autores);
    this.gestionarComicForm.controls.color.setValue(comic.color);

    //this.listaComics = this.listaComics.filter(comic => comic !== comic);
    //this.idComic--;
    this.idComic = posicion;
    this.gestionarComicForm.controls.crear.disable();
//        this.gestionarComicForm.controls.color.enable(); para habilitar el campo

}
    /**
     * Metodo que permite editar un comic de la tabla 
     * @param posicion en la lista del comic seleccionado
     */
    public editarComic() : void {
        
        //this.listaComics = this.listaComics.filter(comic => comic !== comic);
        //this.idComic--;
        let comic = this.listaComics[this.idComic];

        this.comic.id = comic.id;
        this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
        /*this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;
        this.comic.cantidad = 12;*/

        this.gestionarComicService.modificarComic(this.comic).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarComics();
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
    public borrarComic(posicion: number):void{
        let comic = this.listaComics[posicion];
        //this.listaComics = this.listaComics.filter(comic => comic !== comic);
        //this.idComic--;
        console.log("Comic " + JSON.stringify(comic));
        this.gestionarComicService.eliminarComic(comic).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarComics();
                this.limpiarFormulario();
            }
        }, error => {
            console.log(error);
        });
    }
    private limpiarFormulario() : void {
        this.submitted = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() { 
        return this.gestionarComicForm.controls;
    }
}