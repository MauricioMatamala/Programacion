package com.politecnico.urgencia;
import com.politecnico.Paciente;

import java.util.Comparator;

public abstract class UrgenciaMedica {

    private Paciente paciente;
    private int nivelDeUrgencia;

    public abstract int getEspecilidad();
    public String getNombreEspecialidad(){
        return Especialidades.getNombreEspecialidadPorId(getEspecilidad());
    }

    public UrgenciaMedica(){
        nivelDeUrgencia = this.getEspecilidad();
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    public void setNivelDeUrgencia(int nivelDeUrgencia){
        this.nivelDeUrgencia = nivelDeUrgencia;
    }

    public int getNivelDeUrgencia(){
        return nivelDeUrgencia;
    }

    @Override
    public String toString() {
        return paciente + " :" + getNombreEspecialidad();
    }

    public static Comparator<UrgenciaMedica> PRIORIDAD_POR_ESPECIALIDAD = new Comparator<UrgenciaMedica>(){
        @Override
        public int compare(UrgenciaMedica urgenciaMedica, UrgenciaMedica t1) {
            return urgenciaMedica.getNivelDeUrgencia() - t1.getNivelDeUrgencia();
        }
    };
}
