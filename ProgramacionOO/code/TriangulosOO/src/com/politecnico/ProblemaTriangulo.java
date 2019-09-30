package com.politecnico;

public class ProblemaTriangulo {

	public static void main(String[] args) {
		TextUI ui = new TextUI();
		TrianguloRectangulo triangulo = new TrianguloRectangulo();
		double resultado = 0.0;

		ui.registrarPreferenciaUnidad();
		do {
			ui.registrarPreferenciaOperacion();
			if (ui.getOpcionOperacion() != TextUI.OP_FINALIZAR) {
				recabarDatosTriangulo(triangulo, ui);
				resultado = ejecutarOperacion(triangulo, ui);
				ui.mostrarSolucion(resultado);
				ui.mostrarSeparador();
			}
		} while (ui.getOpcionOperacion() != TextUI.OP_FINALIZAR);
	}

	private static void recabarDatosTriangulo(TrianguloRectangulo triangulo, TextUI ui){
		switch (ui.getOpcionOperacion()){
			case TextUI.OP_HIPOTENUSA_POR_CATETOS:
			case TextUI.OP_AREA_POR_CATETOS:
				triangulo.setCateto1(ui.registrarLado(TextUI.LADO_CATETO1));
				triangulo.setCateto2(ui.registrarLado(TextUI.LADO_CATETO2));
				break;
			case TextUI.OP_CATETO_POR_HIPOTENUSA_Y_CATETO:
			case TextUI.OP_AREA_POR_CATETO_HIPOTENUSA:
				triangulo.setHipotenusa(ui.registrarLado(TextUI.LADO_HIPOTENUSA));
				triangulo.setCateto1(ui.registrarLado(TextUI.LADO_CATETO1));
		}
	}

	private static double ejecutarOperacion(TrianguloRectangulo triangulo, TextUI ui){
		double resultado = 0;
		switch (ui.getOpcionOperacion()) {
			case TextUI.OP_HIPOTENUSA_POR_CATETOS:
				resultado = triangulo.hipotenusaPorCatetos();
				break;
			case TextUI.OP_AREA_POR_CATETOS:
				resultado = triangulo.area();
				break;
			case TextUI.OP_CATETO_POR_HIPOTENUSA_Y_CATETO:
				resultado =  triangulo.cateto2PorHipotenusaYCateto1();
				break;
			case TextUI.OP_AREA_POR_CATETO_HIPOTENUSA:
				triangulo.cateto2PorHipotenusaYCateto1();
				resultado = triangulo.area();
		}
		return resultado;
	}

}
