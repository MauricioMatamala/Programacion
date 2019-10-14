package com.politecnico;

import javax.swing.*;

public class JuegoRobot {
    private static InterfazJuego interfazJuego;
    private static Tablero tablero;
    private static Robot robotGanador;

    public static void inicializarJuego(){
        robotGanador = null;
        interfazJuego  = new InterfazJuego();
        interfazJuego.cartelInicioJuego();
        Coordenadas anchoAltoTablero = interfazJuego.pedirAnchoYAltoTablero();
        tablero = new Tablero(anchoAltoTablero);
    }

    public static void crearRobotsParaElJuego(){
        interfazJuego.cartelIntroducirNuevosRobots();
        do{
            String nombreNuevoRobot = interfazJuego.pedirNombreNuevoRobot();
            if (!tablero.estaEnTablero(nombreNuevoRobot)) {
                Robot nuevoRobot = new Robot(nombreNuevoRobot, new Coordenadas(0, 0));
                tablero.anadirRobot(nuevoRobot);
            } else
                interfazJuego.cartelRobotRepetido(nombreNuevoRobot);
        } while (interfazJuego.usuarioDeseaCrearNuevoRobot());
    }

    public static void moverRobotEnTablero( int tipoDeMovimiento, Tablero tablero, String nombreRobot){
        Movimiento movimiento = new Movimiento();
        Robot robotAMover = tablero.getRobot(nombreRobot);
        if (robotAMover != null){
            movimiento.mover(robotAMover.getCoordenadas(),tipoDeMovimiento);
        }
    }

    public static void iniciarJuego(){
        do {
            for (int i = 0; i < tablero.getNumeroActualDeRobots(); i++) {
                Robot robotActual = tablero.getRobot(i);
                interfazJuego.mostrarTurnoRobot(robotActual);
                int movimiento = interfazJuego.pedirMovimientoParaRobot(robotActual.getNombre());
                moverRobotEnTablero(movimiento, tablero, robotActual.getNombre());
                if (tablero.estaRobotEnObjetivo(robotActual.getNombre()))
                        robotGanador = robotActual;
            }
        } while (!hayRobotGanador());
    }

    public static boolean hayRobotGanador(){
        return robotGanador != null;
    }

    public static void main(String[] args) {
        inicializarJuego();
        crearRobotsParaElJuego();
        iniciarJuego();
        interfazJuego.cartelRobotGanador(robotGanador.getNombre());
    }
}
