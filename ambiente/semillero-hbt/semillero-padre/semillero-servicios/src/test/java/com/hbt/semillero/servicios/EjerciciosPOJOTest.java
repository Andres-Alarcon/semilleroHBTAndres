package com.hbt.semillero.servicios;

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
	
	
	@Test
	public void ejercicioTres() {
		
		Assert.assertTrue(ep.validarPrimos(5));
		Assert.assertTrue(ep.validarPrimos(222));
		Assert.assertTrue(ep.validarPrimos(0));
		
	}
}
