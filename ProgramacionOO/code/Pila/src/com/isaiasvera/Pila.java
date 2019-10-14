package com.isaiasvera;

public class Pila {
    Robot[] pila;
    int cima, longitudPila;
//    private static final int LONGITUD_MAXIMA = 1000;
    public Pila (int longitud){
        longitudPila = longitud;
        cima = -1;
        pila = new Robot[longitud];
    }

    public void insertar (Robot robot){
        if (cima < longitudPila-1){
            cima++;
            pila[cima] = robot;
        }else{
            System.out.println("Pila llena loco");
        }
    }
    public Robot extraer (){
        Robot elemento = null;
        if (cima >= 0){
            elemento = pila[cima];
            cima--;
        }else{
            elemento = null;
        }
        return elemento;
    }
    public int cima (){
        return cima;
    }

    public int longitud(){
        return cima+1;
    }

    public boolean estaLlena(){
        return cima == longitudPila-1;
    }

    public boolean estaVacia(){
        return cima == -1;
    }
}
