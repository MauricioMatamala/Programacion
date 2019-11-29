package com.politecnico.urgencia;

public class UrgenciaMedicaFactory {
    public static UrgenciaMedica createUrgenciaMedica(int especialidad){
        switch(especialidad){
            case Especialidades.NEUMOLOGÍA:
                return new UrgenciaNeumología();
            case Especialidades.CARDIOLOGÍA:
                return new UrgenciaCardiología();
            case Especialidades.TOXICOLOGÍA:
                return new UrgenciaToxicología();
            case Especialidades.PEDIATRÍA:
                return new UrgenciaPediatría();
            case Especialidades.PSIQUIATRÍA:
                return new UrgenciaPsiquiatría();
            case Especialidades.DIGESTIVO:
                return new UrgenciaDigestivo();
            case Especialidades.TRAUMATOLOGÍA:
                return new UrgenciaTraumatología();
            case Especialidades.OTORRINO_LARINGOLOGÍA:
                return new UrgenciaOtorrinoLaringólogo();
            case Especialidades.CIRUGÍA:
                return new UrgenciaCirugía();
            case Especialidades.OFTALMOLOGÍA:
                return new UrgenciaOftalmología();
            default:
                return new UrgenciaIndeterminada();
        }
    }

}
