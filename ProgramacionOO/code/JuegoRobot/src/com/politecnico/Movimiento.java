package com.politecnico;

public class Movimiento {
    final static int HACIA_ARRIBA = 1;
    final static int HACIA_DERECHA = 2;
    final static int HACIA_ABAJO = 3;
    final static int HACIA_IZQUIERDA = 4;

    public Coordenadas mover(Coordenadas punto, int movimiento){
        switch(movimiento){
            case HACIA_ARRIBA:
                punto.setY(punto.getY()+1);
                break;
            case HACIA_DERECHA:
                punto.setX(punto.getX()+1);
                break;
            case HACIA_ABAJO:
                punto.setY(punto.getY()-1);
                break;
            case HACIA_IZQUIERDA:
                punto.setX(punto.getX()-1);
        }
        return punto;
    }

    /* AÑADIR EL SIGUIENTE MÉTODO

        public void deshacerMovimiento(Coordenadas coordenadas, int tipoDeMovimiento) {}

     */

}
