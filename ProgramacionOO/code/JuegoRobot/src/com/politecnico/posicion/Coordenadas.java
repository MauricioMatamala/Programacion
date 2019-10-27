package com.politecnico.posicion;

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

    public Vector crearVectorDiferenciaRespectoA(Coordenadas punto){
        int diferenciaX = compararX(punto);
        int diferenciaY = compararY(punto);
        return new Vector(diferenciaX,
                               diferenciaY);
    }

    public boolean equals(Coordenadas punto){
        return (punto.getX() == x) && (punto.getY() == y);
    }

    public String toString(){
        return "(" +
                x +
                "," +
                y +
                ")";
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
