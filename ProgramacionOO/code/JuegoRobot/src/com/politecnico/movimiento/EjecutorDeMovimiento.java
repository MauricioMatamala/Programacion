package com.politecnico.movimiento;

import com.politecnico.posicion.Coordenadas;
import com.politecnico.posicion.Vector;

public abstract class EjecutorDeMovimiento {

    public final static int MOVIMIENTO_EN_L = 1;
    public final static int MOVIMIENTO_EN_DIAGONAL = 2;
    public final static int MOVIMIENTO_EN_CRUZ = 3;

    protected Vector[] listaDeMovimientos;

    public static boolean tipoDeEjecutorEsValido(int tipoDeEjecutorDeMovimiento){
        return ((tipoDeEjecutorDeMovimiento == MOVIMIENTO_EN_L) ||
                (tipoDeEjecutorDeMovimiento == MOVIMIENTO_EN_DIAGONAL) ||
                (tipoDeEjecutorDeMovimiento == MOVIMIENTO_EN_CRUZ));
    }

    public boolean movimientoEsValido(int movimiento){
        return ((movimiento >= 0) && (movimiento < listaDeMovimientos.length));
    }

    public void mover(Coordenadas puntoAMover, int movimiento){
        mover(puntoAMover,listaDeMovimientos[movimiento]);
    }

    public void deshacerMovimiento(Coordenadas puntoAMover, int movimiento){
        Vector vectorMovimientoInverso = listaDeMovimientos[movimiento].clone();
        vectorMovimientoInverso.invertir();
        mover(puntoAMover,vectorMovimientoInverso);
    }

    private void mover(Coordenadas puntoAMover, Vector vectorMovimiento){
        puntoAMover.setX(puntoAMover.getX() + vectorMovimiento.getX());
        puntoAMover.setY(puntoAMover.getY() + vectorMovimiento.getY());
    }

    public String getInterfaceMenu(){
        String interfaceMenu = "";
        for (int i = 0; i < listaDeMovimientos.length; i++){
            Vector vectorDeMovimiento = listaDeMovimientos[i];
            interfaceMenu += i + ". " + componerLineaDeMenu(vectorDeMovimiento) + "\n";
        }
        return interfaceMenu;
    }

    protected abstract String componerLineaDeMenu(Vector vectorDeMovimiento);
}
