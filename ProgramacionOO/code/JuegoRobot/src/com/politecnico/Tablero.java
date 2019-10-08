package com.politecnico;

public class Tablero {
    public final static int MAX_ROBOTS = 3;
    private Coordenadas esquinaSuperiorDerecha;
    private Robot[] listaRobots;
    private Coordenadas casillaObjetivo;
    private int numeroActualDeRobots;

    public Tablero(int ancho, int alto){
        esquinaSuperiorDerecha = new Coordenadas(ancho,alto);
        numeroActualDeRobots = 0;
        listaRobots = new Robot[MAX_ROBOTS];
        casillaObjetivo = new Coordenadas(
                (int) (Math.random()*ancho + 1),
                (int) (Math.random()*alto + 1));
    }

    public boolean estaEnTablero(Coordenadas punto){
        Coordenadas vectorDiferencia = esquinaSuperiorDerecha.compararCon(punto);

        int difX = vectorDiferencia.getX();
        int difY = vectorDiferencia.getY();
        if ((difX > 0) || (difX < -esquinaSuperiorDerecha.getX()) ||
            (difY > 0) || (difY < -esquinaSuperiorDerecha.getX())){
            return false;
        }
        return true;
    }

    public boolean estaEnTablero(String nombreRobot){
        boolean esta = false;
        for (int i = 0; i < numeroActualDeRobots; i++){
            Robot robotActual = listaRobots[i];
            if (robotActual.getNombre().equals(nombreRobot))
                esta = true;
        }
        return esta;
    }

    public void anadirRobot(Robot robot){
        if (numeroActualDeRobots < MAX_ROBOTS) {
            listaRobots[numeroActualDeRobots] = robot;
            numeroActualDeRobots++;
        }
    }

 /*   public boolean estaRobotEnObjetivo(String nombreRobot){}

        public Robot getRobot(String nombreRobot){}

        public int getNumeroActualDeRobots()

        public Robot getRobot(int n)*/



}
