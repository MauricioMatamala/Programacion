package com.politecnico.movimiento;

import com.politecnico.posicion.Coordenadas;
import com.politecnico.posicion.Vector;

public class EjecutorDeMovimientoEnCruz extends EjecutorDeMovimiento {
	private static int TOTAL_MOVIMIENTOS = 4;

	public EjecutorDeMovimientoEnCruz(){
		listaDeMovimientos = new Vector[TOTAL_MOVIMIENTOS];
		listaDeMovimientos[0] = new Vector(0,1, "una casilla hacia arriba");
		listaDeMovimientos[1] = new Vector(1,0,"una casilla hacia la derecha");
		listaDeMovimientos[2] = new Vector(0,-1,"una casilla hacia abajo");
		listaDeMovimientos[3] = new Vector(-1,0, "una casilla hacia la izquierda");
	}

	@Override
	protected String componerLineaDeMenu(Vector vectorDeMovimiento) {
		return "Mover " + vectorDeMovimiento.getDescripcion();
	}
}
