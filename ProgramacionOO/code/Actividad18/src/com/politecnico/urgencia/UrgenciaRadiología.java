package com.politecnico.urgencia;

public class UrgenciaRadiología extends UrgenciaMedica{
    @Override
    public int getEspecilidad() {
        return Especialidades.RADIOLOGÍA;
    }
}
