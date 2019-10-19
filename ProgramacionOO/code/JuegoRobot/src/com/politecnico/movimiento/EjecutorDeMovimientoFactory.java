package com.politecnico.movimiento;

public class EjecutorDeMovimientoFactory {
    public EjecutorDeMovimiento crear(int tipoDeEjecutorDeMovimiento){
        switch (tipoDeEjecutorDeMovimiento){
            case EjecutorDeMovimiento.MOVIMIENTO_EN_L:
                return new EjecutorDeMovimientoEnL();
            case EjecutorDeMovimiento.MOVIMIENTO_EN_CRUZ:
                return new EjecutorDeMovimientoEnCruz();
            case EjecutorDeMovimiento.MOVIMIENTO_EN_DIAGONAL:
                return new EjecutorDeMovimientoDiagonal();
            default:
                return null;
        }
    }
}
