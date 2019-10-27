package com.politecnico;

import com.politecnico.posicion.Coordenadas;

public class Tablero {
    public final static int MAX_ROBOTS = 3;
    //private Coordenadas esquinaSuperiorDerecha;
    private PanelDeJuego panelDeJuego;
    private Robot[] listaRobots;
    private Coordenadas casillaObjetivo;
    private int numeroActualDeRobots;

    public Tablero(Coordenadas esquinaSuperiorDerecha){
        Coordenadas esquinaInferiorIzquierda = new Coordenadas(0,0);
        this.panelDeJuego = new PanelDeJuego(esquinaInferiorIzquierda, esquinaSuperiorDerecha);
        numeroActualDeRobots = 0;
        listaRobots = new Robot[MAX_ROBOTS];
        setCasillaObjetivo();
    }

    private void setCasillaObjetivo(){
        casillaObjetivo = panelDeJuego.generarCasillaObjetivoAleatoria();
        System.out.println("BORRAR: La casilla objetivo es " + casillaObjetivo);
    }

    public boolean estaPuntoEnTablero(Coordenadas punto){
        return panelDeJuego.estaPuntoEnPanel(punto);
    }

    public boolean estaRobotEnTablero(String nombreRobot){
        boolean esta = false;
        for (int i = 0; i < numeroActualDeRobots; i++){
            Robot robotActual = listaRobots[i];

            if (robotActual.getNombre().equalsIgnoreCase(nombreRobot))
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

    public boolean estaRobotEnObjetivo(String nombreRobot){
        Robot robot = getRobotPorNombre(nombreRobot);
        if (robot != null){
            return robot.getCoordenadas().equals(casillaObjetivo);
        }
        return false;
    }

    public Robot getRobotPorNombre(String nombreRobot){
        for (int i=0; i<numeroActualDeRobots; i++){
            if (listaRobots[i].getNombre().equals(nombreRobot)){
                return listaRobots[i];
            }
        }
        return null;
    }

    public int getNumeroActualDeRobots(){
        return numeroActualDeRobots;
    }

    public Robot getRobotEnesimo(int enesimo){
        if ((enesimo >= 0) && (enesimo < numeroActualDeRobots))
            return listaRobots[enesimo];
        else
            return null;
    }

}
