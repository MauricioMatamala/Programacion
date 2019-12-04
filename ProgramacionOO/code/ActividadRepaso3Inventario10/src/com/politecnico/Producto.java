package com.politecnico;

import java.util.HashMap;

public class Producto {
    private String id;
    HashMap<Componente,Integer> especificaciones;

    public Producto(String id){
        this.id = id;
        especificaciones = new HashMap<>();
    }

    public String getId(){
        return id;
    }

    public HashMap<Componente,Integer> getEspecificaciones(){
        return especificaciones;
    }

    public void addEspecificación(Componente componente, Integer cantidad){
        especificaciones.putIfAbsent(componente,cantidad);
    }

    @Override
    public boolean equals(Object obj) {
        Producto otroProducto = (Producto) obj;
        return id.equals(otroProducto.getId());
    }
}
