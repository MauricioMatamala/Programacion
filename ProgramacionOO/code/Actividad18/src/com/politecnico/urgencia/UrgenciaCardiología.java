package com.politecnico.urgencia;

public class UrgenciaCardiología extends UrgenciaMedica{
    @Override
    public int getEspecilidad() {
        return Especialidades.CARDIOLOGÍA;
    }
}
