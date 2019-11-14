package com.hbt.semillero.servicios;

import java.time.LocalDate;
import java.time.Month;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPOJO;

public class EjerciciosPOJOTest {

	private static String brand;
	private static boolean empty;
	
	private EjerciciosPOJO ep = new EjerciciosPOJO();
	
	/*@Test
	public void ejercicioUno() {
		
		String a$b;
		String _helloWorld;
		//String true;
		//String java.lang;
		String Public;
		//String 1980_s;
		
		//Las variables en comentarios, no corresponden a identificadores validos
		//Assert.assertTrue(a$b , "Tipo de dato valido");
	}
	/*
	@Test
	public static void ejercicioDos() {
		
		System.out.println("Empty="+empty);
		System.out.println(", Brand = "+brand);
	}
	*/
	
	/*
	@Test
	public void ejercicioTres() {
		
		Assert.assertTrue(ep.validarPrimos(5));
		Assert.assertTrue(ep.validarPrimos(222));
		Assert.assertTrue(ep.validarPrimos(0));
		
	}*/
	/*
	 * Metodo que llama el metodo del POJO validar Edad, y le asigan los parametros de prueba
	 * */
	/*
	@Test
	public void ejericioCuatro() {
		Assert.assertTrue(ep.validarEdad(LocalDate.of(1995, Month.SEPTEMBER,6), 24L));
	}
	*/
	
	//Metodo que prueba, agregar los numeros, verificar el menor y el mayor, y el tamaño del array
	@Test
	public void ejercicioCinco() {
		
		//Se cargan los datos
		ep.ingresarDatos(50);
		ep.ingresarDatos(1);
		ep.ingresarDatos(249);
		ep.ingresarDatos(-2);
		
		//Se prueba que no este nulo
		Assert.assertNotNull(ep.getNumeros());
		
		//Se imprime la lista
		System.out.println(ep.getNumeros().toString());
		
		//Se ordena la lista
		ep.ordenar();
		
		//Se imprime la lista ya ordenada
		System.out.println(ep.getNumeros().toString());
		
		//Se prueba que el primer elemento es -2
		Assert.assertEquals(ep.getNumeros().get(0).toString(),"-2");
		//Se prueba que el ultimo es 249
		Assert.assertEquals(ep.getNumeros().get(3).toString(),"249");
		
		//Se comprueba el tamaño de la lista
		Assert.assertEquals(ep.getNumeros().size(), 4);
	}
	//Metodo que prueba los metodos implementados en POJO para validar el ganador de una partida de tennis
	@Test public void ejercicioSiete() {
		
		//Se cargan los valores de prueba
		ep.cargarPuntajes("Roger Federer", 3);
		ep.cargarPuntajes("Dominic Thiem", 6);
		ep.cargarPuntajes("Roger Federer", 2);
		ep.cargarPuntajes("Dominic Thiem", 6);
		
		Assert.assertEquals(ep.definirGanador(), "Gano el jugador Dominic");
	}
}
