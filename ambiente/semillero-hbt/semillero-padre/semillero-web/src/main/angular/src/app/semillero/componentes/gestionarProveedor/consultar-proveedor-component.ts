import { ProveedorDTO } from '../../dto/proveedor.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { stringify } from 'querystring';

/**
 * Componente que se encargará de mostrar la información de un comic en específico
 */
@Component({
    selector: 'consultar-proveedor',
    templateUrl: './consultar-proveedor-component.html',
})

export class ConsultarProveedorComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public consultarProveedorForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public proveedor: ProveedorDTO;

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
        this.consultarProveedorForm = this.fb.group({
            id : [null, Validators.required],
            direccion : [null],
            fecha : [null],
            estado : [null],
            idPersona : [null],
            monto : [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Andres Felipe Alarcon Fonseca
     */
    ngOnInit(): void {
        
        this.proveedor = new ProveedorDTO();
        this.datos = this.activatedRoute.snapshot.params;
        //console.log("Datos recibidos en consultar" + JSON.stringify(this.datos));
        this.cargarDatosProveedor();

    }
    /**
     * Metodo que carga los datos recibidos a los campos de formulario, y posterior los desactiva, solo lectura
     */
    public cargarDatosProveedor () : void{
        this.consultarProveedorForm.controls.id.setValue(this.datos.id);
        this.consultarProveedorForm.controls.direccion.setValue(this.datos.direccion);
        this.consultarProveedorForm.controls.fecha.setValue(this.datos.fechaCreacion);
        this.consultarProveedorForm.controls.estado.setValue(this.datos.estado);
        this.consultarProveedorForm.controls.idPersona.setValue(this.datos.idPersona);
        this.consultarProveedorForm.controls.monto.setValue(this.datos.montoCredito);
        this.consultarProveedorForm.controls.id.disable();
        this.consultarProveedorForm.controls.direccion.disable();
        this.consultarProveedorForm.controls.fecha.disable();
        this.consultarProveedorForm.controls.estado.disable();
        this.consultarProveedorForm.controls.idPersona.disable();
        this.consultarProveedorForm.controls.monto.disable();
    }
    /**
     * Metodo que captura el click del boton y lo redirige al componente gestionar-comic
     */
    public regresar():void{
        this.router.navigateByUrl('/gestionar-provedor');
    }
    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Andres Felipe Alarcon Fonseca
     */
    get f() { 
        return this.consultarProveedorForm.controls;
    }
}    