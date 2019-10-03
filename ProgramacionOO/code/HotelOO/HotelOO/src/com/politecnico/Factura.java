package com.politecnico;

public class Factura {
    Cliente cliente;
    String textoFactura;
    int numeroDias;

    public Factura(Cliente cliente, int numeroDias){
        // Genera una cadena de texto correspondiente a la factura y la almacena en textoFactura.
        // Una factura puede ser algo como:
        //
        // ====================================
        // CLIENTE: Carlos Antúnez
        // HABITACIÓN OCUPADA: 110
        // DIAS DE ESTANCIA: 5
        // TIPO DE HABITACIÓN: Simple
        // TOTAL A PAGAR: 300€
        // ====================================
    }

    public String getTextoFactura(){
        // Devuelve la factura calculada previamente.
    }
}
