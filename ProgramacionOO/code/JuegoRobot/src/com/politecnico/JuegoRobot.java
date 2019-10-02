package com.politecnico;

public class JuegoRobot {

    public static void mostrarInfoPunto(Coordenadas punto){
        System.out.println("Las coordenadas son (" +
                punto.getX() + "," +
                punto.getY() + ")");
    }

    public static void mostrarInfoRobot(Robot robot){
        System.out.println( robot.getNombre() +
                            "---> (" +
                            robot.getCoordenadas().getX() +
                            "," +
                            robot.getCoordenadas().getY());
    }

    public static void main(String[] args) {
        Coordenadas punto = new Coordenadas(0,0);
        mostrarInfoPunto(punto);
        Movimiento movimiento = new Movimiento();
        punto = movimiento.mover(punto,Movimiento.HACIA_ARRIBA);
        mostrarInfoPunto(punto);

        //-------------------------
        Robot robot1 = new Robot("C3PO",new Coordenadas(0,0));
        mostrarInfoRobot(robot1);
        //-------------------------

        Coordenadas punto1 = new Coordenadas(4,5);
        Coordenadas punto2 = new Coordenadas(0,0);

        Coordenadas punto3 = punto1.compararCon(punto2);
        System.out.println("Punto3 = (" + punto3.getX() +
                                      "," +
                                        punto3.getY()+")");


    }
}
