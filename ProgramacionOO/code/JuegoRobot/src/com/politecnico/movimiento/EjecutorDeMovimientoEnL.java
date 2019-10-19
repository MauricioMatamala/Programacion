package com.politecnico.movimiento;

import com.politecnico.posicion.Vector;

public class EjecutorDeMovimientoEnL extends EjecutorDeMovimiento {
    private static int NUMERO_TOTAL_MOVIMIENTOS = 8;

    // private Coordenadas[] listaDeMovimientos;
    public EjecutorDeMovimientoEnL() {
        listaDeMovimientos = new Vector[NUMERO_TOTAL_MOVIMIENTOS];
        listaDeMovimientos[0] = new Vector(1, 2, "una casilla hacia la derecha y dos hacia arriba");
        listaDeMovimientos[1] = new Vector(-1, 2, "una casilla hacia la izquierda y dos hacia arriba");
        listaDeMovimientos[2] = new Vector(-2, 1, "dos casillas hacia la izquierda y una hacia arriba");
        listaDeMovimientos[3] = new Vector(-2, -1, "dos casillas hacia la izquierda y una hacia abajo");
        listaDeMovimientos[4] = new Vector(-1, -2, "una casilla hacia la izquierda y dos hacia abajo");
        listaDeMovimientos[5] = new Vector(1, -2, "una casilla hacia la derecha y dos hacia abajo");
        listaDeMovimientos[6] = new Vector(2, -1, "dos casillas hacia la derecha y una hacia abajo");
        listaDeMovimientos[7] = new Vector(2, 1, "dos casillas hacia la derecha y una hacia arriba");
    }

    @Override
    protected String componerLineaDeMenu(Vector vectorMovimiento) {
        return "Mover " + vectorMovimiento.getDescripcion();
    }
}
