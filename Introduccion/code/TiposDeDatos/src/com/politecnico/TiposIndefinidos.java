package com.politecnico;

public class TiposIndefinidos {
    public static void main(String[] args) {
        ComprobadorTipo comprobadorTipo = new ComprobadorTipo();
        var tiempo = 10.1;  // El compilador decide que tiempo es de tipo 'double'
                            // ¡OJO! Sólo se puede usar esta característica de Java
                            // a partir de Java 10.

        System.out.println(tiempo);
        comprobadorTipo.mostrarTipo("tiempo",tiempo);
    }
}
