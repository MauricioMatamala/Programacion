package com.politecnico.urgencia;

public class UrgenciaCirugía extends UrgenciaMedica{
    @Override
    public int getEspecilidad() {
        return Especialidades.CIRUGÍA;
    }
}
