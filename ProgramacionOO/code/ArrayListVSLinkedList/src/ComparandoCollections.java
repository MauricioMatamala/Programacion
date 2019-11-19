import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ComparandoCollections {
    private static final int ITERACIONES = 10000;
    private static ArrayList<Double> aList = new ArrayList<>();
    private static LinkedList<Double> lList = new LinkedList<>();

    private static void insertarXNumerosAleatorios(List<Double> list,int totalNumeros){
        for (int i = 0; i<totalNumeros; i++){
            double aleatorio = ThreadLocalRandom.current().nextDouble(0,50);
            list.add(aleatorio);
        }
    }

    private static void inicializarListas(List<Double> list){
        insertarXNumerosAleatorios(list,100000);
        list.add(70.0);
        insertarXNumerosAleatorios(list,100000);
    }

    private static double cronometrar(MétodoAEjecutar método){
        long[] tiempos = new long[ITERACIONES];
        for (int i=0;i<ITERACIONES;i++){
            long inicio = System.nanoTime();
            método.ejecutar();
            long duracion = System.nanoTime() - inicio;
            tiempos[i] = duracion;
        }
        return Arrays.stream(tiempos).average().getAsDouble();
    }

    public static void main(String[] args) {
        inicializarListas(aList);
        inicializarListas(lList);

        System.out.println("IndexOf(ArrayList): " + cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                aList.indexOf(70.0);
            }
        }));

        System.out.println("IndexOf(LinkedList): " + cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                lList.indexOf(70.0);
            }
        }));

        System.out.println("Get(ArrayList): " + cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                aList.get(1000);
            }
        }));

        System.out.println("Get(LinkedList): " + cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                lList.get(1000);
            }
        }));

        System.out.println("AddFirst(ArrayList): " + cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                aList.add(0, 0.0);
            }
        }));

        System.out.println("AddFirst(LinkedList): " + cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                lList.addFirst(0.0);
            }
        }));

        System.out.println("InsertarEnMedio(ArrayList): " + cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                aList.add(100, 0.0);
            }
        }));

        System.out.println("InsertarEnMedio(LinkedList): " + cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                lList.add(100, 0.0);
            }
        }));

        System.out.println("AddLast(ArrayList): " + cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                aList.add(aList.size(), 0.0);
            }
        }));

        System.out.println("AddLast(LinkedList): " +cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                lList.addLast(0.0);
            }
        }));

        System.out.println("RemoveFirst(ArrayList): " + cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                aList.remove(0);
            }
        }));

        System.out.println("RemoveFirst(LinkedList): " + cronometrar(new MétodoAEjecutar() {
            @Override
            public void ejecutar() {
                lList.removeFirst();
            }
        }));
    }
}
