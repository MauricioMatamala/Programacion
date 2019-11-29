package com.politecnico;

import com.politecnico.urgencia.UrgenciaMedica;

import java.util.PriorityQueue;

public class SalaEspera {
    private PriorityQueue<UrgenciaMedica> colaEspera;
    private SalaEsperaChangeListener salaEsperaChangeListener;

    public SalaEspera(){
        colaEspera = new PriorityQueue<>(UrgenciaMedica.PRIORIDAD_POR_ESPECIALIDAD);
    }

    public void addUrgenciaMedica(UrgenciaMedica urgenciaMedica){
        colaEspera.add(urgenciaMedica);
        salaEsperaChangeListener.onChangeDo();
    }

    public UrgenciaMedica siguienteUrgencia(){
        UrgenciaMedica siguienteUrgencia = colaEspera.poll();
        salaEsperaChangeListener.onChangeDo();
        return siguienteUrgencia;
    }

    public PriorityQueue getColaEspera(){
        return colaEspera;
    }

    public void setSalaEsperaChangeListener(SalaEsperaChangeListener listener){
        salaEsperaChangeListener = listener;
    }
}
