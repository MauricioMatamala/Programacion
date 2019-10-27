package com.politecnico;

import com.politecnico.movimiento.EjecutorDeMovimiento;
import com.politecnico.movimiento.EjecutorDeMovimientoFactory;
import com.politecnico.posicion.Coordenadas;

public class JuegoRobot {
    private static InterfazJuego interfazJuego;
    private static Tablero tablero;
    private static Robot robotGanador;

    public static void main(String[] args) {
        inicializarJuego();
        crearRobotsParaElJuego();
        iniciarJuego();
        interfazJuego.cartelRobotGanador(robotGanador.getNombre());
    }

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
            String nombreNuevoRobot = obtenerNombreDeNuevoRobotNoRepetido();
            Robot nuevoRobot = new Robot(nombreNuevoRobot, new Coordenadas(0, 0));
            tablero.anadirRobot(nuevoRobot);
        } while (interfazJuego.usuarioDeseaCrearNuevoRobot());
    }

    public static void iniciarJuego(){
        do {
            for (int i = 0; i < tablero.getNumeroActualDeRobots() && !hayRobotGanador(); i++) {
                Robot robotActual = tablero.getRobotEnesimo(i);
                interfazJuego.mostrarTurnoRobot(robotActual);
                moverRobotEnTablero(robotActual);
                if (tablero.estaRobotEnObjetivo(robotActual.getNombre()))
                    robotGanador = robotActual;
            }
        } while (!hayRobotGanador());
    }

    private static String obtenerNombreDeNuevoRobotNoRepetido(){
        boolean robotNoRepetidoObtenido = false;
        String nombreNuevoRobot = "";
        while (!robotNoRepetidoObtenido) {
            nombreNuevoRobot = interfazJuego.pedirNombreNuevoRobot();
            if (!tablero.estaRobotEnTablero(nombreNuevoRobot))
                robotNoRepetidoObtenido = true;
            else
                interfazJuego.cartelRobotRepetido(nombreNuevoRobot);
        }
        return nombreNuevoRobot;
    }

    private static void moverRobotEnTablero(Robot robotActual) {
        if (robotActual != null) {
            EjecutorDeMovimiento ejecutorDeMovimiento = obtenerEjecutorDeMovimientoValido(robotActual.getNombre());
            int movimiento = obtenerMovimientoValido(robotActual.getNombre(), ejecutorDeMovimiento);
            ejecutorDeMovimiento.mover(robotActual.getCoordenadas(),movimiento);
            if (!tablero.estaPuntoEnTablero(robotActual.getCoordenadas()))
                ejecutorDeMovimiento.deshacerMovimiento(robotActual.getCoordenadas(),movimiento);
            interfazJuego.mostrarPosicionRobot(robotActual);
        }
    }

    private static int obtenerMovimientoValido(String nombreRobot, EjecutorDeMovimiento ejecutorDeMovimiento){
        int movimiento = interfazJuego.pedirMovimientoParaRobot(nombreRobot, ejecutorDeMovimiento);
        while (!ejecutorDeMovimiento.movimientoEsValido(movimiento)){
            interfazJuego.cartelMovimientoNoValido();
            movimiento = interfazJuego.pedirMovimientoParaRobot(nombreRobot, ejecutorDeMovimiento);
        }
        return movimiento;
    }

    private static EjecutorDeMovimiento obtenerEjecutorDeMovimientoValido(String nombreRobot){
        int tipoEjecutorDeMovimiento = interfazJuego.pedirTipoDeEjecutorDeMovimiento(nombreRobot);
        while (!EjecutorDeMovimiento.tipoDeEjecutorEsValido(tipoEjecutorDeMovimiento)){
            interfazJuego.cartelEjecutorDeMovimientoNoValido();
            tipoEjecutorDeMovimiento = interfazJuego.pedirTipoDeEjecutorDeMovimiento(nombreRobot);
        }
        EjecutorDeMovimientoFactory ejecutorDeMovimientoFactory = new EjecutorDeMovimientoFactory();
        return ejecutorDeMovimientoFactory.crear(tipoEjecutorDeMovimiento);
    }

    public static boolean hayRobotGanador(){
        return robotGanador != null;
    }
}
