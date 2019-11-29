package com.politecnico.urgencia;

public class UrgenciaPsiquiatría extends UrgenciaMedica{
    @Override
    public int getEspecilidad() {
        return Especialidades.PSIQUIATRÍA;
    }
}
