package com.hbt.semillero.pojo;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EjerciciosPOJO {

	//Array que almacena los datos
	private ArrayList<Integer> numeros = new ArrayList<Integer>();
	
	public boolean validarPrimos(int numero) {
		
		int contador=2;
		//Contador en 2 porque el uno cumple la condicion, sera el divisor
		for (int i = 0; i < numero; i++) {
			if (numero % contador == 0) {
				return false;
			}
			contador++;
		}
		return true;
	}
	
	public boolean validarEdad(LocalDate fecha, Long edad) {
		
		//Se suman la edad de la persona, años
		LocalDate calculado = fecha.plusYears(edad);
		// Fecha actual
		LocalDate actual = LocalDate.now();
		
		if (calculado.isEqual(actual)) {
			return true;
		}
		
		return false;
	}
	//Metodo que recibe por parametro el numero a agregar, y lo adiciona al Array
	public void ingresarDatos(int numero) {
		this.numeros.add(numero);
	}
	//Metodo que ordena los datos de menor a mayor
	public void ordenar() {
		//Se hace uso de la clase Collections
		Collections.sort(this.numeros);
	}

	
	//Metodo que obtiene el array
	public ArrayList<Integer> getNumeros() {
		return numeros;
	}
	
	
}
