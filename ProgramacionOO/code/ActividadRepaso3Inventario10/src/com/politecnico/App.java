package com.politecnico;

import com.politecnico.xml.ArchivoInventarioXML;
import com.politecnico.xml.ArchivoProductosXML;

import java.util.HashMap;

public class App {
	public static void main(String[] args) {

		// Lectura del archivo "productos.xml"

		ArchivoProductosXML archivoProductosXML = new ArchivoProductosXML();
		Productos productos = archivoProductosXML.leerProductosXML("productos.xml");

		//----------------------------------------------------------------------------------------------------------
		// Apartado 3a). Lectura del archivo "inventario.xml"

		ArchivoInventarioXML archivoInventarioXML = new ArchivoInventarioXML();
		Inventario inventario = archivoInventarioXML.leerInventarioXML("inventario.xml");

		// Asignar listener a inventario para mostrar mensaje cuando haya escasez de existencias de componentes

		inventario.setExistenciasEscasasListener(INFORMAR_SI_COMPONENTES_ESCASOS);

		//----------------------------------------------------------------------------------------------------------
		// Apartado 2. Mostrar inventario por pantalla

		System.out.println("==============================================================");
		System.out.println("||       APARTADO 2. MOSTRAR INVENTARIO POR PANTALLA        ||");
		System.out.println("==============================================================");

		System.out.println(inventario);

		//----------------------------------------------------------------------------------------------------------
		// Apartado 1. Mostrar mensaje cuando escasean las existencias.

		System.out.println("==============================================================================");
		System.out.println("||       APARTADO 1. MOSTRAR MENSAJE CUANDO ESCASEAN LAS EXISTENCIAS        ||");
		System.out.println("==============================================================================");

		Producto productoP1 = productos.getProductoById("P1");

		boolean límiteDeEscasezSuperado = false;
		while (!límiteDeEscasezSuperado){
			System.out.println("Contabilizando nuevo producto P1");
			límiteDeEscasezSuperado = inventario.hayComponentesEscasos(productoP1);
			inventario.contabilizarNuevoProducto(productoP1); // contabilizarNuevoProducto lanza el método "informar" del listener "INFORMAR_SI_COMPONENTES_ESCASOS" cuando hay escasez de existencias.
			System.out.println(inventario);
		}

		//---------------------------------------------------------------------------------------------------------
		// Apartado 3b). Escribir el inventario en el archvio "inventario2.xml"

		System.out.println("==============================================================================");
		System.out.println("||       APARTADO 3b. ESCRIBIR INVENTARIO AL ARCHIVO \"inventario2.xml\"     ||");
		System.out.println("==============================================================================");

		archivoInventarioXML.escribirInventarioAXML(inventario,"inventario2.xml");
	}

	public static ExistenciasEscasasListener INFORMAR_SI_COMPONENTES_ESCASOS = new ExistenciasEscasasListener() {
		@Override
		public void informar(HashMap<Componente, Integer> escasos) {
			System.out.println("================================================================");
			System.out.println("||					COMPONENTES ESCASOS						  ||");
			System.out.println("================================================================");
			escasos.forEach((componente,existencias) -> {
				System.out.println("Componente: " + componente + ". Quedan únicamente " + existencias + " unidades");
			});
			System.out.println("================================================================");
			System.out.println("||           FIN NOTIFICACIÓN DE COMPONENTES ESCASOS	      ||");
			System.out.println("================================================================");
		}
	};
}
