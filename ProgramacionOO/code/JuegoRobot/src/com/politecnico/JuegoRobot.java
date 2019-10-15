package com.politecnico;

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

    private static String obtenerNombreDeNuevoRobotNoRepetido(){
        boolean robotNoRepetidoObtenido = false;
        String nombreNuevoRobot = "";
        while (!robotNoRepetidoObtenido) {
            nombreNuevoRobot = interfazJuego.pedirNombreNuevoRobot();
            if (!tablero.estaEnTablero(nombreNuevoRobot))
                robotNoRepetidoObtenido = true;
            else
                interfazJuego.cartelRobotRepetido(nombreNuevoRobot);
        }
        return nombreNuevoRobot;
    }

    public static void crearRobotsParaElJuego(){
        interfazJuego.cartelIntroducirNuevosRobots();
        do{
            String nombreNuevoRobot = obtenerNombreDeNuevoRobotNoRepetido();
            Robot nuevoRobot = new Robot(nombreNuevoRobot, new Coordenadas(0, 0));
            tablero.anadirRobot(nuevoRobot);
        } while (interfazJuego.usuarioDeseaCrearNuevoRobot());
    }

    public static void moverRobotEnTablero( int tipoDeMovimiento, Tablero tablero, String nombreRobot){
        Movimiento movimiento = new Movimiento();
        Robot robotAMover = tablero.getRobot(nombreRobot);
        if (robotAMover != null){
            movimiento.mover(robotAMover.getCoordenadas(),tipoDeMovimiento);
        }
    }

    public static int obtenerMovimientoValido(String nombreRobot){
        Movimiento verificadorMovimiento = new Movimiento();
        int movimiento = Movimiento.MOVIMIENTO_NO_VALIDO;
        while (!verificadorMovimiento.movimientoValido(movimiento)){
            movimiento = interfazJuego.pedirMovimientoParaRobot(nombreRobot);
            if (!verificadorMovimiento.movimientoValido(movimiento))
                interfazJuego.cartelMovimientoNoValido();
        }
        return movimiento;

    }

    public static void iniciarJuego(){
        do {
            for (int i = 0; i < tablero.getNumeroActualDeRobots(); i++) {
                Robot robotActual = tablero.getRobot(i);
                interfazJuego.mostrarTurnoRobot(robotActual);
                int movimiento = obtenerMovimientoValido(robotActual.getNombre());
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
