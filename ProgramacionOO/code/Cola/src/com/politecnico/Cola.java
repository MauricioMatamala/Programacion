package com.politecnico;

public class Cola {
    private int tail, head;
    private int[] elementos;
    private int elementosAlmacenados = 0;

    public Cola(int tamanoCola){
        head = 0;
        tail = -1;
        elementos = new int[tamanoCola];
    }

    public int sacar(){
       int elemento;
       if (!estaVacia()) {
           elemento = elementos[head];
           head++;
           if (head == elementos.length)
            head = 0;
           elementosAlmacenados--;
       } else
          elemento = Integer.MIN_VALUE;

       return elemento;
    }

    public void meter(int nuevoElemento){
        if (estaVacia()){
            tail = head;
        }else if (!estaLlena()){
            tail++;
            elementosAlmacenados++;
            if (tail == elementos.length)
                tail = 0;
        }
        elementos[tail] = nuevoElemento;
    }

    public boolean estaVacia(){
        return (tail == -1);
    }

    public boolean estaLlena(){
        return ( tail + 1 ) % elementos.length == head;
    }

    private int numeroElementos(){
        int temp = (tail - head) % elementos.length;
        if (temp < 0)
            temp = (elementos.length + temp) + 1;
        else
            temp++;
        return temp;


        //return (( tail - head ) % elementos.length ) + 1;
        //return elementosAlmacenados;
    }

    public String toString() {
        String contenidoCola = "HEAD (" + head + ")";
        int totalElementosRecorridos = 0;
        for (int i=head; totalElementosRecorridos < numeroElementos(); i++){
            i = i%elementos.length;
            contenidoCola += "|" + elementos[i] + "|";
            totalElementosRecorridos++;
        }

        contenidoCola += "TAIL(" + tail + ")";
        return contenidoCola;
    }
}
