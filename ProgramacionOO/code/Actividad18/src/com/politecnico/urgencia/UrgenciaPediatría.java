package com.politecnico.urgencia;

public class UrgenciaPediatría extends UrgenciaMedica{
    @Override
    public int getEspecilidad() {
        return Especialidades.PEDIATRÍA;
    }
}
