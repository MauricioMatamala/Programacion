package com.isaiasvera;

public class PilaApp {
    private static Pila pila;
    private static final int LONGITUD_MAXIMA = 10;

    public static void imprimirExtraido(Robot robot){
        System.out.println("El valor extraído es :" + robot.saludo());
    }

    public static void imprimirCima(Pila pila){
        System.out.println("El valor de la cima es : " + pila.cima());
    }

    public static void imprimirVacia(Pila pila){
        if (pila.estaVacia())
            System.out.println("La pila está vacía");
        else
            System.out.println("La pila no está vacía");
    }

    public static void imprimirLlena(Pila pila){
        if (pila.estaLlena())
            System.out.println("La pila está llena");
        else
            System.out.println("La pila no está llena");
    }

    public static void imprimirLongitud(Pila pila){
        System.out.println("La longitud de la pila es " + pila.longitud());
    }

    public static void main(String[] args) {
        pila = new Pila(LONGITUD_MAXIMA);
        Robot nano = new NanoBot();
        Robot mega = new MegaBot();
        Robot mid = new MidBot();

        pila.insertar(nano);
        pila.insertar(mega);
        pila.insertar(mid);

        imprimirExtraido(pila.extraer());
        imprimirExtraido(pila.extraer());
        imprimirExtraido(pila.extraer());
    }
}
