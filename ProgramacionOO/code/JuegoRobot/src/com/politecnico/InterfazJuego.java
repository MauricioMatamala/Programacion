package com.politecnico;

import com.politecnico.movimiento.EjecutorDeMovimiento;
import com.politecnico.posicion.Coordenadas;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class InterfazJuego {
	Scanner lectorTeclado;

	public InterfazJuego(){
		lectorTeclado = new Scanner(System.in).useDelimiter("\n");
	}

	public void cartelInicioJuego(){
		System.out.println("BIENVENIDO AL JUEGO DE LOS ROBOTS\n" +
				"==================================\n\n");
	}

	public void cartelIntroducirNuevosRobots(){
		System.out.println("\n\nAHORA DEBES INTRODUCIR NUEVOS ROBOTS\n" +
							"=========================================\n\n");
	}

	public Coordenadas pedirAnchoYAltoTablero(){
		int ancho = -1, alto = -1;
		while ((ancho < 0) && (alto < 0)){
			ancho = pedirEnteroMostrandoMensaje("Por favor, indica el ancho del tablero [1-?]:");
			alto = pedirEnteroMostrandoMensaje("Por favor, indica el alto del tablero: [1-?]:");
			if ((ancho < 0) || (alto < 0)){
				System.out.println("El ancho y el alto deben ser números mayores de que cero. Por favor, vuelva a introducir valores válidos.");
			}
		}
		return new Coordenadas(ancho,alto);
	}

	public String pedirNombreNuevoRobot(){
		System.out.print("Por favor, indique el nombre del nuevo robot :");
		return lectorTeclado.next();
	}

	public void cartelRobotRepetido(String nombreNuevoRobot){
		System.out.println("El robot " + nombreNuevoRobot + " ya existe. Por favor, elija otro nombre");
	}

	public boolean usuarioDeseaCrearNuevoRobot(){
		System.out.println("¿Desea crear un nuevo robot? (Pulse S para responder Sí, o cualquier otra tecla para responder No) :");
		String respuesta = lectorTeclado.next();
		if (respuesta.toUpperCase().equals("S"))
			return true;
		else
			return false;
	}

	public void mostrarTurnoRobot(Robot robot){
		if (robot != null) {
			System.out.println("=====================================");
			System.out.println("  TURNO DEL ROBOT " + robot.getNombre());
			System.out.println("=====================================");
			mostrarPosicionRobot(robot);
		}
	}

	public int pedirTipoDeEjecutorDeMovimiento(String nombreRobot) {
		return pedirEnteroMostrandoMensaje("\nElija el tipo de movimiento para " + nombreRobot  + ":\n" +
				EjecutorDeMovimiento.MOVIMIENTO_EN_L + ". Movimiento en L\n" +
				EjecutorDeMovimiento.MOVIMIENTO_EN_DIAGONAL + ". Movimiento diagonal\n" +
				EjecutorDeMovimiento.MOVIMIENTO_EN_CRUZ + ". Movimiento en cruz\n" +
				"Opción: ");
	}

	public int pedirMovimientoParaRobot(String nombreRobot, EjecutorDeMovimiento ejecutorDeMovimiento){
		return pedirEnteroMostrandoMensaje("\nElija un movimiento para " + nombreRobot + "\n" +
														    ejecutorDeMovimiento.getInterfaceMenu() + "\n" +
				                                           "Opción: ");

	}

	public void cartelEjecutorDeMovimientoNoValido(){
		System.out.println("Este tipo de movimiento no existe. Por favor, indique un tipo de movimiento válido");
	}

	public void cartelMovimientoNoValido(){
		System.out.println("Este movimiento no existe. Por favor, indique un movimiento válido");
	}

	public void cartelRobotGanador(String nombreRobotGanador){
		System.out.println("=======================================================================");
		System.out.println("EL ROBOT GANADOR ES: " + nombreRobotGanador);
		System.out.println("=======================================================================");
	}

	private int pedirEnteroMostrandoMensaje(String mensajeMostrado){
		System.out.print(mensajeMostrado);
		String textoIntroducido = lectorTeclado.next();
		if (textoIntroducido.matches("[0-9]*")){
			return Integer.parseInt(textoIntroducido);
		} else
			return Integer.MIN_VALUE;
	}

	public void mostrarPosicionRobot(Robot robot){
		System.out.println("--------------------------------------------------------------------");
		System.out.println("INFORMACIÓN: La posición actual de " + robot.getNombre() + " es " + robot.getCoordenadas());
		System.out.println("--------------------------------------------------------------------");
	}
}
