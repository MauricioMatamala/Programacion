package com.politecnico;

import java.util.Scanner;

public class TextUI {
	public final static int MED_MM = 1;
	public final static int MED_CM = 2;
	public final static int MED_M = 3;

	public final static int OP_HIPOTENUSA_POR_CATETOS = 1;
	public final static int OP_CATETO_POR_HIPOTENUSA_Y_CATETO = 2;
	public final static int OP_AREA_POR_CATETO_HIPOTENUSA = 3;
	public final static int OP_AREA_POR_CATETOS = 4;
	public final static int OP_FINALIZAR = 5;

	public final static int LADO_HIPOTENUSA = 1;
	public final static int LADO_CATETO1 = 2;
	public final static int LADO_CATETO2 = 3;

	private Scanner lectorTeclado;
	private int opcionUnidad;
	private int opcionOperacion;

	TextUI(){
		lectorTeclado = new Scanner(System.in);
		opcionOperacion = 0;
		opcionUnidad = 0;
	}

	public void registrarPreferenciaUnidad(){
		mostrarMenuUnidad();
		leerPreferenciaUnidad();
	}

	public void registrarPreferenciaOperacion(){
		mostrarMenuOperacion();
		leerPreferenciaOperacion();
	}

	public double registrarLado(int lado){
		mostrarMensajeLado(lado);
		return leerLado();
	}

	private void mostrarMenuUnidad() {
		System.out.print("¿Qué unidad desea utilizar?:\n" +
				"1. mm\n" +
				"2. cm\n" +
				"3. m\n" +
				"Elige una opción:");
	}

	private void leerPreferenciaUnidad(){
		this.opcionUnidad = lectorTeclado.nextInt();
	}

	private void mostrarMenuOperacion(){
		System.out.print(	"1. Calcular la hipotenusa de un triángulo a aprtir de sus catetos.\n" +
				"2. Calcular un cateto de un triángulo a partir de el otro cateto y la hipotenusa\n" +
				"3. Calcular el área de un triángulo a partir un cateto y la hipotenusa.\n" +
				"4. Caluclar el área de un triángulo a partir de dos catetos.\n" +
				"5. Finalizar el programa.\n" +
				"Elige una opción:");
	}

	private void leerPreferenciaOperacion(){
		this.opcionOperacion = lectorTeclado.nextInt();
	}

	private void mostrarMensajeLado(int lado){
		String mensaje = "Por favor, introduce la longitud ";
		if (lado == LADO_HIPOTENUSA) mensaje += "de la hipotenusa:";
		else if (lado == LADO_CATETO1) mensaje += "del primer cateto:";
		else if (lado == LADO_CATETO2) mensaje += "del segundo cateto:";
		System.out.print(mensaje);
	}

	private double leerLado(){
		return lectorTeclado.nextDouble();
	}

	public void mostrarSolucion(double resultado){
		String mensajeSolucion = ladoResultadoToString();
		mensajeSolucion += Double.toString(resultado);
		mensajeSolucion += opcionUnidadToString();
		System.out.println(mensajeSolucion);
	}

	public void mostrarSeparador(){
		System.out.println("\n\n-------------------------------------------------\n\n");
	}

	private String ladoResultadoToString(){
		String ladoResultadoString = "";
		switch(opcionOperacion){
			case OP_HIPOTENUSA_POR_CATETOS:
				ladoResultadoString += "La hipotenusa mide ";
				break;
			case OP_CATETO_POR_HIPOTENUSA_Y_CATETO:
				ladoResultadoString += "El cateto mide ";
				break;
			case OP_AREA_POR_CATETO_HIPOTENUSA:
			case OP_AREA_POR_CATETOS:
				ladoResultadoString += "El área mide ";
		}
		return ladoResultadoString;
	}

	private String opcionUnidadToString(){
		String opcionUnidadString = "";

		switch (opcionUnidad){
			case MED_MM:
				opcionUnidadString += " mm";
				break;
			case MED_CM:
				opcionUnidadString += " cm";
				break;
			case MED_M:
				opcionUnidadString += " m";
		}

		if ((opcionOperacion == OP_AREA_POR_CATETO_HIPOTENUSA) || (opcionOperacion == OP_AREA_POR_CATETOS))
			return opcionUnidadString + "²";
		else
			return opcionUnidadString;
	}

	public int getOpcionUnidad() {
		return opcionUnidad;
	}

	public void setOpcionUnidad(int opcionUnidad) {
		this.opcionUnidad = opcionUnidad;
	}

	public int getOpcionOperacion() {
		return opcionOperacion;
	}

	public void setOpcionOperacion(int opcionOperacion) {
		this.opcionOperacion = opcionOperacion;
	}
}
