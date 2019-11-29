package com.politecnico.urgencia;

public class UrgenciaToxicología extends UrgenciaMedica{
    @Override
    public int getEspecilidad() {
        return Especialidades.TOXICOLOGÍA;
    }
}
