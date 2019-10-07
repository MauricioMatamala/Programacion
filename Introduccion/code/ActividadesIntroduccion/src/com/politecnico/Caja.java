package com.politecnico;

public class Caja {
    private int ancho;
    private int alto;
    private int fondo;

    public Caja(int ancho, int alto, int fondo) {
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }
}
