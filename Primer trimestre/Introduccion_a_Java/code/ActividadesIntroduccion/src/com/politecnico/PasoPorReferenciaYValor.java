package com.politecnico;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class PasoPorReferenciaYValor {

    public static void cambiarAnchoCaja(Caja caja){
        caja.setAncho(23);
        System.out.println("Dentro de cambiarAnchoCaja, el ancho es " + caja.getAncho());

    }

    public static int cambiarNumero(int numero){
        numero++;
        System.out.println("Dentro de cambiarNumero, n = " + numero);
        return numero;
    }

    public static void main(String[] args) {
        Caja c = new Caja(3,2,1);
        int n = 5;

        c = cambiarAnchoCaja(c);
        n = cambiarNumero(n);

        System.out.println("En main, el ancho es " + c.getAncho());
        System.out.println("En main, el número es " + n);

    }
}
