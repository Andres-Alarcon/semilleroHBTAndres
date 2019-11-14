package com.hbt.semillero.pojo;

public class EjerciciosPOJO {

	
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
}
