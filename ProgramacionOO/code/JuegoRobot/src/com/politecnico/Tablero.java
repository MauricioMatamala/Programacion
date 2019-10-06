package com.politecnico;

public class Tablero {
    private Coordenadas esquinaSuperiorDerecha;
    /*

        AÑADIR CÓDIGO PARA:
         - MANTENER UNA LISTA DE ROBOTS.
         - ALMACENAR LA POSICIÓN DE LA CASILLA OBJETIVO

     */

    public Tablero(int ancho, int alto){
        esquinaSuperiorDerecha = new Coordenadas(ancho,alto);
    }

    /*
    TERMINAR ESTE MÉTODO

    public boolean estaEnTablero(Coordenadas punto){
        Coordenadas vectorDiferencia = esquinaSuperiorDerecha.compararCon(punto);
        if (vectorDis)
    }*/

    /* AGREGAR LOS SIGUIENTES MÉTODOS

        public boolean estaEnTablero(String nombreRobot){}

        public void anadirRobot(Robot robot){}

        public boolean estaRobotEnObjetivo(String nombreRobot){}

        public Robot getRobot(String nombreRobot){}
    */


}
