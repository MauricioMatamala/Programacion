package com.politecnico;

public class Tablero {
    public final static int MAX_ROBOTS = 100;
    private Coordenadas esquinaSuperiorDerecha;
    private Robot[] listaRobots;
    private Coordenadas casillaObjetivo;

    public Tablero(int ancho, int alto){
        esquinaSuperiorDerecha = new Coordenadas(ancho,alto);
        listaRobots = new Robot[MAX_ROBOTS];
        casillaObjetivo.setCoordenadas(
                (int) (Math.random()*ancho + 1),
                (int) (Math.random()*alto + 1)
        );
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

    /* AGREGAR LOS SIGUIENTES MÉTODOS

        public boolean estaEnTablero(String nombreRobot){}

        public void anadirRobot(Robot robot){}

        public boolean estaRobotEnObjetivo(String nombreRobot){}

        public Robot getRobot(String nombreRobot){}

        public int getNumeroActualDeRobots()

        public Robot getRobot(int n)
    */


}
