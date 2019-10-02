package com.politecnico;

public class Coordenadas {
    private int x, y;

    public Coordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setCoordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordenadas compararCon(Coordenadas punto){
        int diferenciaX = compararX(punto);
        int diferenciaY = compararY(punto);
        return new Coordenadas(diferenciaX,
                               diferenciaY);
    }

    public int compararX(Coordenadas punto){
        return punto.getX() - x;
    }

    public int compararY(Coordenadas punto){
        return punto.getY() - y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
