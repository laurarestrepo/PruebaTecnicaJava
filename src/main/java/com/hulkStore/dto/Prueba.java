package com.hulkStore.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Prueba {

	public static void main(String[] args) throws ParseException {
		
	
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaString = "1983-08-03";
		Date fechaNacimiento = formatter.parse(fechaString);
		
		Calendar calFechaNacimiento = Calendar.getInstance();
		calFechaNacimiento.setTime(fechaNacimiento);
		
		Calendar fechaActual = Calendar.getInstance();
		
		int ano = fechaActual.get(Calendar.YEAR) - calFechaNacimiento.get(Calendar.YEAR);
		//int mes = fechaActual.get(Calendar.MONTH) - calFechaNacimiento.get(Calendar.MONTH);
		//int dia = fechaActual.get(Calendar.DATE) - calFechaNacimiento.get(Calendar.DATE);
		
		int anoHoy = fechaActual.get(Calendar.YEAR);
		int anoHeroe = calFechaNacimiento.get(Calendar.YEAR);
		
		int mesHoy = fechaActual.get(Calendar.MONTH);
		int mesHeroe = calFechaNacimiento.get(Calendar.MONTH);
		
		int diaHoy = fechaActual.get(Calendar.DATE);
		int diaHeroe = calFechaNacimiento.get(Calendar.DATE);
		
		
		
		if (mesHoy<mesHeroe && diaHoy < diaHeroe )
		{
			ano = ano -1;
			
		}
		
				
		System.out.print(ano); 
		System.out.println();
		System.out.printf("Hoy es el año %d", anoHoy);
		System.out.println();
		System.out.printf("Hoy es el mes %d", mesHoy);
		System.out.println();
		System.out.printf("Hoy es el día %d",diaHoy);
		
		System.out.println();
		System.out.printf("Hoy es el año Heroe %d", anoHeroe);
		System.out.println();
		System.out.printf("Hoy es el mes Heroe %d", mesHeroe);
		System.out.println();
		System.out.printf("Hoy es el día Heroe%d",diaHeroe);

	}

}
