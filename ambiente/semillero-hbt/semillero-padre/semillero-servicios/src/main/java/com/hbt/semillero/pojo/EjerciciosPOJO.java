package com.hbt.semillero.pojo;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EjerciciosPOJO {

	//Array que almacena los datos
	private ArrayList<Integer> numeros = new ArrayList<Integer>();
	
	//Mapa que almacenara los respectivos puntajes
	private Map<String, Integer> marcadores = new HashMap<String, Integer>();
	
	
	
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
		
	//Metodo que carga los respectivos puntajes al mapa
		public void cargarPuntajes(String nombreJugador, int puntaje) {
			marcadores.put(nombreJugador, puntaje);
		}
		
		//Metodo que realiza la validacion del ganador, de acuerdo a los datos ya cargados
		public String definirGanador() {
			
			int puntajeFederer=0;
			int puntajeThiem=0;
			
			//For para iterar sobre el mapa
			for (Map.Entry<String, Integer> entry : marcadores.entrySet()) {
				
				if (entry.getKey().equals("Roger Federer")) {
					puntajeFederer = puntajeFederer + entry.getValue();
				}
				else if (entry.getKey().equals("Dominic Thiem")) {
					puntajeThiem = puntajeThiem + entry.getValue();
				}
			}
			if (puntajeFederer>puntajeThiem) {
				return "Gano el jugador Federer";
			}
			else {
				return "Gano el jugador Dominic";
			}
		}
	//Metodo que  optimiza el numero de monedas que se deben dar como cambio	
	public String devolverCambio(Integer cambio) {
		
		Integer residuo=0;
		Integer monedasMil=0;
		Integer monedasQuin=0;
		Integer monedasDos=0;
		Integer monedasCien=0;
		Integer monedasCinCu=0;
		
		while (cambio!=0) {
			if (cambio >= 1000) {
				residuo = cambio % 1000;
			}
		}
		return "";
	}
	//Linea 7, se completa con b 
	// Linea 8 se completa con D
	public void ejercicioNueve() throws Exception {
		throw new Exception();
	}
	
	
}
