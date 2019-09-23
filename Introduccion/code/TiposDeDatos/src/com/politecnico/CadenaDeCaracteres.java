package com.politecnico;

public class CadenaDeCaracteres {
    public static void main(String[] args) {

        String cadena1 = "Pepe;Juan;María";
        String cadena2 = "Pepe;Juan;María"; // Case sensitive

        // ------- Comparando cadenas --------------------

        System.out.println(" cadena1 == cadena2 = " +  cadena1.equals(cadena2));

        // ------- StringBuffer ---------------------------

        StringBuffer s = new StringBuffer();
        s.append("Hola").append(" ").append("mundo");
        s.insert(5,"a todo el ");
        System.out.println(s.toString());


        // -------- Combinando varios métodos de String --------

        String subcadena1, subcadena2, subcadena3;

        subcadena1 = cadena1.substring(0,5);
        subcadena2 = cadena1.substring(5,10).toUpperCase();
        subcadena3 = cadena1.substring(10);

        // -----------------------------------------------------

        cadena1 = subcadena1.concat(subcadena2).concat(subcadena3);
        System.out.println(cadena1);

        String[] nombres = cadena1.split(";");

        System.out.println(nombres[2]);
    }

}
