package com.politecnico;

import com.politecnico.posicion.Coordenadas;

public class PanelDeJuego {
    Coordenadas esquinaSuperiorDerecha,
                esquinaInferiorIzquierda;

    public PanelDeJuego(int ancho, int alto){
        esquinaInferiorIzquierda = new Coordenadas(0,0);
        esquinaSuperiorDerecha = new Coordenadas(ancho-1, alto-1);
    }

    public PanelDeJuego(Coordenadas esquinaInferiorIzquierda, Coordenadas esquinaSuperiorDerecha){
        this.esquinaSuperiorDerecha = esquinaSuperiorDerecha;
        this.esquinaInferiorIzquierda = esquinaInferiorIzquierda;
    }

    public boolean estaPuntoEnPanel(Coordenadas punto){
        boolean estaEnX = (punto.getX() >= esquinaInferiorIzquierda.getX()) &&
                        (punto.getX() <= esquinaSuperiorDerecha.getX());
        boolean estaEnY = (punto.getY() >= esquinaInferiorIzquierda.getY()) &&
                        (punto.getY() <= esquinaSuperiorDerecha.getY());
        return estaEnX && estaEnY;
    }

    public Coordenadas generarCasillaObjetivoAleatoria(){
        Coordenadas casillaObjetivo = null;
        if (esquinaSuperiorDerecha != null)
            casillaObjetivo = new Coordenadas(
                    (int) (Math.random() * esquinaSuperiorDerecha.getX() + 1),
                    (int) (Math.random() * esquinaSuperiorDerecha.getY() + 1)
            );
        return casillaObjetivo;
    }
}
