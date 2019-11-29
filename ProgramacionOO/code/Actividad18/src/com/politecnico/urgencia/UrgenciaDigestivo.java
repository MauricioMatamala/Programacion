package com.politecnico.urgencia;

public class UrgenciaDigestivo extends UrgenciaMedica{
    @Override
    public int getEspecilidad() {
        return Especialidades.DIGESTIVO;
    }
}
