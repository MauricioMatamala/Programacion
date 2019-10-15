package com.politecnico;

public class Tablero {
    public final static int MAX_ROBOTS = 3;
    private Coordenadas esquinaSuperiorDerecha;
    private Robot[] listaRobots;
    private Coordenadas casillaObjetivo;
    private int numeroActualDeRobots;

    public Tablero(int ancho, int alto){
        this(new Coordenadas(ancho,alto));
    }

    public Tablero(Coordenadas esquinaSuperiorDerecha){
        this.esquinaSuperiorDerecha = esquinaSuperiorDerecha;
        numeroActualDeRobots = 0;
        listaRobots = new Robot[MAX_ROBOTS];
        setCasillaObjetivo();
    }

    private void setCasillaObjetivo(){
        if (esquinaSuperiorDerecha != null)
            casillaObjetivo = new Coordenadas(
                    (int) (Math.random() * esquinaSuperiorDerecha.getX() + 1),
                    (int) (Math.random() * esquinaSuperiorDerecha.getY() + 1)
            );
        System.out.println("BORRAR: La casilla objetivo es " + casillaObjetivo);
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
        Robot robot = getRobot(nombreRobot);
        if (robot != null){
            return robot.getCoordenadas().equals(casillaObjetivo);
        }
        return false;
    }

    public Robot getRobot(String nombreRobot){
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

    public Robot getRobot(int nEsimo){
        if ((nEsimo >= 0) && (nEsimo < numeroActualDeRobots))
            return listaRobots[nEsimo];
        else
            return null;
    }

}
