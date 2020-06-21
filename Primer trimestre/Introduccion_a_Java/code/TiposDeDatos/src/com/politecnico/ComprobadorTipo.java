package com.politecnico;

public class ComprobadorTipo {

	public void mostratTipo(String nombreVariable, short variable){
		System.out.println("La variable " + nombreVariable + " es de tipo short");
	}

	public void mostrarTipo(String nombreVariable, char variable){
		System.out.println("La variable " + nombreVariable + " es de tipo char");
	}

	public void mostrarTipo(String nombreVariable, int variable){
		System.out.println("La variable " + nombreVariable + " es de tipo int");
	}

	public void mostrarTipo(String nombreVariable, long variable){
		System.out.println("La variable " + nombreVariable + " es de tipo long");
	}

	public void mostrarTipo(String nombreVariable, float variable){
		System.out.println("La variable " + nombreVariable + " es de tipo float");
	}

	public void mostrarTipo(String nombreVariable, double variable){
		System.out.println("La variable " + nombreVariable + " es de tipo double");
	}
}
