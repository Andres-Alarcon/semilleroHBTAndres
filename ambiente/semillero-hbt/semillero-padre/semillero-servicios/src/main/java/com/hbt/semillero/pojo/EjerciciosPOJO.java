package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EjerciciosPOJO {

	//Array que almacena los datos
	private ArrayList<Integer> numeros = new ArrayList<Integer>();
	
	//Mapa que almacenara los respectivos puntajes
	private Map<String, Integer> marcadores = new HashMap<String, Integer>();
	
	//Array para la secuencia
	private ArrayList<Integer> secuencia = new ArrayList<Integer>();
	
	
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
	
	//Se carga la secuencia
	public void cargarDatos(Integer numero) {
		this.secuencia.add(numero);
	}
	
	//Metodo que valida que le numero que viene por parametro satisfaga la secuencia, la suma de los dos digitos, 
	//debe incrementar en 1 para la suma siguiente
	public boolean validarNumeroSiguiente(Integer numero) {
		
		// Se parte el numero que llega por parametro
		String digitoUno = numero.toString().substring(0,1);
		String digitoDos = numero.toString().substring(1);
		//Se obtiene el ultimo elemento del array
		String ultimo = this.secuencia.get(this.secuencia.size()-1).toString();
		//Se parte este numero
		String digitoUnoArray = ultimo.substring(0,1);
		String digitoUDosArray = ultimo.substring(1);
		//Se realizan las sumas correspondientes
		Integer sumaParametro = Integer.parseInt(digitoUno) + Integer.parseInt(digitoDos);
		Integer sumaElementoArray = Integer.parseInt(digitoUnoArray) + Integer.parseInt(digitoUDosArray);
		//Se valida que se cumpla el valor de incremento
		if (sumaParametro-sumaElementoArray == 1) {
			return true;
		}
		
		return false;
	}
	
	public ArrayList<Integer> getSecuencia() {
		return secuencia;
	}
	
	
}
