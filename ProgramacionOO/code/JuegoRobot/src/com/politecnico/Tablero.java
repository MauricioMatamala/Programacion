package com.politecnico;

public class Tablero {
    private Coordenadas esquinaSuperiorDerecha;

    public Tablero(int ancho, int alto){
        esquinaSuperiorDerecha = new Coordenadas(ancho,alto);
    }

    /*public boolean estaEnTablero(Coordenadas punto){
        Coordenadas vectorDiferencia = esquinaSuperiorDerecha.compararCon(punto);
        if (vectorDis)
    }*/
}
