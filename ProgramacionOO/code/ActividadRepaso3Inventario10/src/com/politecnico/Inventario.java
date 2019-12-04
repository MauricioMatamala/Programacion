package com.politecnico;

import java.util.HashMap;

public class Inventario {
    HashMap<Componente,Integer> existencias;
    ExistenciasEscasasListener existenciasEscasasListener;

    public Inventario(){
        existencias = new HashMap<>();
    }

    public Inventario(HashMap<Componente,Integer> existencias){
        this.existencias = existencias;
    }

    public void setExistenciasEscasasListener(ExistenciasEscasasListener listener){
        existenciasEscasasListener = listener;
    }

    public void addExistencia(Componente componente, int cantidad){
        if (existencias.containsKey(componente))
            reponerExistencia(componente,cantidad);
        else
            existencias.put(componente,cantidad);
    }

    public HashMap<Componente,Integer> getExistencias(){
        return existencias;
    }

    public void reponerExistencia(Componente componente, int cantidad){
        ajustarExistencia(componente,cantidad);
    }

    public void decrementarExistencia(Componente componente, int cantidad){
        ajustarExistencia(componente,-cantidad);
    }

    public void contabilizarNuevoProducto(Producto producto){
        HashMap<Componente,Integer> especificaciones = producto.getEspecificaciones();
        if (!hayComponentesEscasos(producto)) {
            especificaciones.forEach((componente, cantidad) -> {
                decrementarExistencia(componente, cantidad);
            });
        } else {
            existenciasEscasasListener.informar(obtenerComponentesEscasos(especificaciones));
        }
    }

    public boolean hayComponentesEscasos(Producto producto){
        HashMap<Componente, Integer> componentesEscasos = obtenerComponentesEscasos(producto.getEspecificaciones());
        return (componentesEscasos.size() > 0);
    }

    private HashMap<Componente, Integer> obtenerComponentesEscasos(HashMap<Componente, Integer> especificaciones) {
        HashMap<Componente,Integer> componentesEscasos = new HashMap<>();
        especificaciones.forEach((componente,cantidad) -> {
            if (existencias.get(componente) - cantidad*10 < 0)
                componentesEscasos.put(componente,existencias.get(componente));
        });
        return componentesEscasos;
    }

    private void ajustarExistencia(Componente componente, int cantidad){
        if (existencias.containsKey(componente)) {
            Integer cantidadActual = existencias.get(componente);
            if ((cantidad < 0) && (Math.abs(cantidad) > cantidadActual)) throw new ExistenciasInsuficientesException("No quedan suficiente componentes " + componente.getId());
            else existencias.put(componente,cantidadActual + cantidad);
        } else
            throw new ComponenteNoEnAlmacenException("El componente " + componente.getId() + " no existe en el almacén");
    }

    @Override
    public String toString() {
        return "Inventario{" +
                existencias +
                "}";
    }
}
