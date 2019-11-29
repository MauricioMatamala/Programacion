package com.politecnico.urgencia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Especialidades {
    public final static int NEUMOLOGÍA = 1;
    public final static int CARDIOLOGÍA = 2;
    public final static int TOXICOLOGÍA = 3;
    public final static int PEDIATRÍA = 4;
    public final static int PSIQUIATRÍA = 5;
    public final static int RADIOLOGÍA = 6;
    public final static int DIGESTIVO = 7;
    public final static int TRAUMATOLOGÍA = 8;
    public final static int OTORRINO_LARINGOLOGÍA = 9;
    public final static int CIRUGÍA = 10;
    public final static int OFTALMOLOGÍA = 11;
    public final static int INDETERMINADA = 12;

    public static Map<Integer,String> getNombresEspecialidades(){
        Map<Integer,String> especialidades = new HashMap<>();
        especialidades.put(NEUMOLOGÍA,"Neumología");
        especialidades.put(CARDIOLOGÍA,"Cardiología");
        especialidades.put(TOXICOLOGÍA,"Toxicología");
        especialidades.put(PEDIATRÍA,"Pediatría");
        especialidades.put(PSIQUIATRÍA,"Psiquiatría");
        especialidades.put(RADIOLOGÍA, "Radiología");
        especialidades.put(DIGESTIVO,"Digestivo");
        especialidades.put(TRAUMATOLOGÍA,"Traumatología");
        especialidades.put(OTORRINO_LARINGOLOGÍA,"Otorrinolaringología");
        especialidades.put(CIRUGÍA,"Cirugía");
        especialidades.put(OFTALMOLOGÍA,"Oftalmología");
        especialidades.put(INDETERMINADA,"Indeterminada");
        return especialidades;
    }

    public static String getNombreEspecialidadPorId(int especialidad){
        return getNombresEspecialidades().get(especialidad);
    }

    public static int getIdEspecialidadPorNombre(String nombreEspecialidad){
        Map<Integer,String> especialidades = getNombresEspecialidades();
        Iterator<Integer> it = especialidades.keySet().iterator();
        while (it.hasNext()) {
            int especialidad = it.next();
            if (especialidades.get(especialidad) == nombreEspecialidad)
                return especialidad;
        }
        return INDETERMINADA;
    }
}