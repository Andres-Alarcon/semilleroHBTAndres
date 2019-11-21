import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarProveedorService } from '../../services/gestionar.proveedor.service';
import { ProveedorDTO } from '../../dto/proveedor.dto';

/**
 * @description Componenete gestionar persona, el cual contiene la logica CRUD
 * 
 * @author Andrés Felipe Alarcón Fonseca
 */
@Component({
    selector: 'gestionar-proveedor',
    templateUrl: './gestionar-proveedor-component.html'
})
export class GestionarProveedorComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarProveedorForm : FormGroup;

    /**
     * Atributo que contendra la informacion del proveedor
     */
    public proveedor: ProveedorDTO;

    /**
     * Atributo que contendra la lista de proveedores creados
     */
    public listaProveedores : Array<ProveedorDTO>;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    /**
     * @description Este es el constructor del componente GestionarProveedorComponent
     * @author Andrés Felipe Alarcón Fonseca
     */
    constructor(private fb : FormBuilder,
        private router : Router,
        private gestionarProveedorService : GestionarProveedorService) {
        this.gestionarProveedorForm = this.fb.group({
            id : [null, Validators.required],
            direccion : [null],
            fecha : [null],
            estado : [null],
            idPersona : [null],
            monto : [null]
        });
        
    }
    ngOnInit(): void {
        this.proveedor = new ProveedorDTO();
        this.listaProveedores = new Array<ProveedorDTO>();
        this.consultarProveedores();
    }
    /**
     * @description Metodo encargado de consultar las personas existentes
     * @author Andrés Felipe Alarcón Fonseca
     */
    public consultarProveedores() : void {
        this.gestionarProveedorService.consultarProveedores().subscribe(listaProveedores => {
            this.listaProveedores = listaProveedores;
        }, error => {
            console.log(error);
        });
    }

        /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearProveedor() : void {
        this.submitted = true;
        if(this.gestionarProveedorForm.invalid) {
            return;
        }
        this.proveedor = new ProveedorDTO();
        this.proveedor.id = this.gestionarProveedorForm.controls.id.value;
        //console.log("id en crear: "+ this.gestionarProveedorForm.controls.id.value);
        this.proveedor.direccion = this.gestionarProveedorForm.controls.direccion.value;
        this.proveedor.fechaCreacion = this.gestionarProveedorForm.controls.fecha.value;
        this.proveedor.estado = this.gestionarProveedorForm.controls.estado.value;
        this.proveedor.idPersona = this.gestionarProveedorForm.controls.idPersona.value;
        this.proveedor.montoCredito = this.gestionarProveedorForm.controls.monto.value;
  
        this.gestionarProveedorService.crearProveedor(this.proveedor).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarProveedores();
                this.limpiarFormulario();
            }
        }, error => {
            console.log(error);
            this.limpiarFormulario();
        });
    }

    private limpiarFormulario() : void {
        this.submitted = false;
        this.gestionarProveedorForm.controls.id.setValue(null);
        this.gestionarProveedorForm.controls.direccion.setValue(null);
        this.gestionarProveedorForm.controls.fecha.setValue(null);
        this.gestionarProveedorForm.controls.estado.setValue(null);
        this.gestionarProveedorForm.controls.idPersona.setValue(null);
        this.gestionarProveedorForm.controls.monto.setValue(null);
    }

}