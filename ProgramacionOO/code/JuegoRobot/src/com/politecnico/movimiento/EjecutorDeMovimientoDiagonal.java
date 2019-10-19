package com.politecnico.movimiento;

import com.politecnico.posicion.Vector;

public class EjecutorDeMovimientoDiagonal extends EjecutorDeMovimiento {
	private static int TOTAL_MOVIMIENTOS = 4;

	public EjecutorDeMovimientoDiagonal(){
		listaDeMovimientos = new Vector[TOTAL_MOVIMIENTOS];
		listaDeMovimientos[0] = new Vector(1,1, "una casilla hacia el noreste");
		listaDeMovimientos[1] = new Vector(1,-1,"una casilla hacia el sureste");
		listaDeMovimientos[2] = new Vector(-1,-1, "una casilla hacia el suroeste");
		listaDeMovimientos[3] = new Vector(-1,1,"una casilla hacia el noroeste");
	}

	@Override
	protected String componerLineaDeMenu(Vector vectorDeMovimiento) {
		return "Mover " + vectorDeMovimiento.getDescripcion();
	}
}
