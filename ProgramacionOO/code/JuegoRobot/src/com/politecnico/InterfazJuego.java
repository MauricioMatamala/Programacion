package com.politecnico;

import java.util.Scanner;

public class InterfazJuego {
	Scanner lectorTeclado;

	public InterfazJuego(){
		lectorTeclado = new Scanner(System.in).useDelimiter("\n");
	}

	public void cartelIntroducirNuevosRobots(){
		System.out.println("\n\nAHORA DEBES INTRODUCIR NUEVOS ROBOTS\n" +
							"=========================================\n\n");
	}

	public void cartelInicioJuego(){
		System.out.println("BIENVENIDO AL JUEGO DE LOS ROBOTS\n" +
							"==================================\n\n");
	}

	private int pedirEnteroMostrandoMensaje(String mensajeMostrado){
		System.out.print(mensajeMostrado);
		String textoIntroducido = lectorTeclado.next();
		if (textoIntroducido.matches("[0-9]*")){
			return Integer.parseInt(textoIntroducido);
		} else
			return Integer.MIN_VALUE;
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
			System.out.println("-------------------------------------");
			System.out.println("Turno del robot " + robot.getNombre());
			System.out.println(robot.getNombre() + " está en la posición " + robot.getCoordenadas());
		}
	}

	public void cartelMovimientoNoValido(){
		System.out.println("Este movimiento no existe. Por favor, indique un movimiento válido");
	}

	public int pedirMovimientoParaRobot(String nombreRobot){
		return pedirEnteroMostrandoMensaje("Elija un movimiento para " + nombreRobot + "\n" +
				Movimiento.HACIA_ARRIBA + ". Hacia arriba\n" +
				Movimiento.HACIA_DERECHA + ". Hacia la derecha\n" +
				Movimiento.HACIA_ABAJO + ". hacia abajo\n" +
				Movimiento.HACIA_IZQUIERDA + ". hacia la izquierda\n" +
				"Elija una opción: ");
		 /*do {
		 	movimiento = pedirMovimientoParaRobot();
			if ((movimiento < 1) || (movimiento > 4))
				System.out.println("El movimiento elegido debe estar entre 1 y 4. Por favor, vuelva a introducir valores válidos");
		} while ((movimiento < 1) || (movimiento > 4));
		return movimiento;*/
	}

	public void cartelRobotGanador(String nombreRobotGanador){
		System.out.println("=======================================================================");
		System.out.println("EL ROBOT GANADOR ES: " + nombreRobotGanador);
		System.out.println("=======================================================================");
	}

}
