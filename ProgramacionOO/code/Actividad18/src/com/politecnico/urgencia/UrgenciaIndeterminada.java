package com.politecnico.urgencia;

public class UrgenciaIndeterminada extends UrgenciaMedica {
    @Override
    public int getEspecilidad() {
        return Especialidades.INDETERMINADA;
    }
}
