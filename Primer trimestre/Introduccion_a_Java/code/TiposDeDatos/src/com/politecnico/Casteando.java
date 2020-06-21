package com.politecnico;

public class Casteando {
    public static void main( String[] args ) {
        ComprobadorTipo comprobadorTipo = new ComprobadorTipo();
        int numeroEntero = 5;
        long numeroLong = 2000000000000L;   // La L al final indica que es un número de tipo 'long'
                                            // Si no la pongo, el compilador dedicidirá por defecto que es un 'int'
                                            // No es un problema normalmente, pero en este caso, el número
                                            // es demasiado largo para ser un int.

        comprobadorTipo.mostrarTipo("numeroEntero * numeroLong", numeroLong * numeroEntero); // Casting automático.
                                                                                                                    // numeroEntero promociona automáticamente a tipo 'long'
        comprobadorTipo.mostrarTipo("numeroEntero", (long) numeroEntero);   // casting explícito. numeroEntero es promocionado a tipo 'long'
        comprobadorTipo.mostrarTipo("numeroEntero * numeroLong",
                                          (int) numeroLong * numeroEntero); // Casting explícito. El resultado de la multiplicación
                                                                                    // (que inicialmente es de tipo 'long'), es degradado
                                                                                    // a 'int'.

        // OJO con los castings a tipos no compatibles (por ejemplo, long -> int), porque la información puede
        // verse comprometida si hay un truncamiento de los datos. Lee la siguiente noticia:
        //
        // http://www.rtve.es/noticias/20140604/error-software-convirtio-lanzamiento-espacial-carisimos-fuegos-artificiales/948262.shtml
        //************************************************************************************************************
        //*                         ¿Qué pasa cuando se hace un casting entre tipos incompatibles?                   *
        //*                         https://www.youtube.com/watch?time_continue=3&v=gp_D8r-2hwk                      *
        //************************************************************************************************************
        //

        System.out.println("numeroLong * numeroEntero = " + numeroLong * numeroEntero);
    }
}
