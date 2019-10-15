package com.politecnico;

public class Movimiento {
    final static int HACIA_ARRIBA = 1;
    final static int HACIA_DERECHA = 2;
    final static int HACIA_ABAJO = 3;
    final static int HACIA_IZQUIERDA = 4;
    final static int MOVIMIENTO_NO_VALIDO = -1;
    final static int NUMERO_MOVIMIENTOS = 4;
    int[] movimientosValidos;

    public Movimiento(){
        movimientosValidos = new int[NUMERO_MOVIMIENTOS];
        movimientosValidos[0] = HACIA_ARRIBA;
        movimientosValidos[1] = HACIA_DERECHA;
        movimientosValidos[2] = HACIA_IZQUIERDA;
        movimientosValidos[3] = HACIA_ABAJO;
    }

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

    public void deshacerMovimiento(Coordenadas coordenadas, int tipoDeMovimiento) {
        switch(tipoDeMovimiento){
            case HACIA_ABAJO:
                mover(coordenadas,HACIA_ARRIBA);
                break;
            case HACIA_ARRIBA:
                mover(coordenadas,HACIA_ABAJO);
                break;
            case HACIA_IZQUIERDA:
                mover(coordenadas,HACIA_DERECHA);
                break;
            case HACIA_DERECHA:
                mover(coordenadas,HACIA_IZQUIERDA);
        }
    }

    public boolean movimientoValido(int movimiento){
        boolean encontrado = false;
        for (int i=0; i < NUMERO_MOVIMIENTOS && !encontrado; i++){
            if (movimiento == movimientosValidos[i])
                encontrado = true;
        }
        return encontrado;
    }

}
