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

    private static double calcularMediaIndexOf(List<Double> list){
        long[] tiempos = new long[ITERACIONES];
        for (int i=0;i<ITERACIONES;i++){
            tiempos[i] = cronometrarIndexOf(list);
        }
        return Arrays.stream(tiempos).average().getAsDouble();
    }

    private static long cronometrarIndexOf(List<Double> list) {
        long inicio = System.nanoTime();
        list.indexOf(70.0);
        return System.nanoTime() - inicio;
    }

    private static double calcularMediaInsert(List<Double> list,int pos) {
        long[] tiempos = new long[ITERACIONES];
        for (int i=0;i<ITERACIONES;i++){
            tiempos[i] = cronometrarInsert(list,pos);
        }
        return Arrays.stream(tiempos).average().getAsDouble();
    }

    private static long cronometrarInsert(List<Double> list,int pos){
        long inicio = System.nanoTime();
        if (pos > 0) {
            list.add(pos, 0.0);
        } else{
            list.add(0.0);
        }
        return System.nanoTime() - inicio;
    }

    private static double calcularMediaInsertFirst(LinkedList<Double> list) {
        long[] tiempos = new long[ITERACIONES];
        for (int i=0;i<ITERACIONES;i++){
            tiempos[i] = cronometrarInsertFirst(list);
        }
        return Arrays.stream(tiempos).average().getAsDouble();
    }

    private static long cronometrarInsertFirst(LinkedList<Double> list){
        long inicio = System.nanoTime();
        list.addFirst(0.0);
        return System.nanoTime() - inicio;

    }

    private static double calcularMediaBorrar(List<Double> list) {
        long[] tiempos = new long[ITERACIONES];
        for (int i=0;i<ITERACIONES;i++){
            tiempos[i] = borrarCabeza(list);
        }
        return Arrays.stream(tiempos).average().getAsDouble();
    }

    private static long borrarCabeza(List<Double> list){
        long inicio = System.nanoTime();
        list.remove(0);
        return System.nanoTime() - inicio;

    }
    

    public static void main(String[] args) {
        inicializarListas(aList);
        inicializarListas(lList);

        System.out.println("IndexOf(ArrayList):"+calcularMediaIndexOf(aList)); // O(n)
        System.out.println("IndexOf(LinkedList):"+calcularMediaIndexOf(lList)); // O(n)

        // Calcular Get

        System.out.println("Insert Principio(ArrayList):" + calcularMediaInsert(aList,0));
        System.out.println("Insert Principio(LinkedList):" + calcularMediaInsertFirst(lList));

        System.out.println("Insert en medio(ArrayList):" + calcularMediaInsert(aList,aList.size()/2));
        System.out.println("Insert en medio(LinkedList):" + calcularMediaInsert(lList,lList.size()/2));

        System.out.println("Insert al final(ArrayList):" + calcularMediaInsert(aList,-1));
        System.out.println("Insert al final(LinkedList):" + calcularMediaInsert(lList,-1));

        System.out.println("Borrar cabeza(ArrayList):" + calcularMediaBorrar(aList));
        System.out.println("Borrar cabeza(LinkedList)" + calcularMediaBorrar(lList));

    }
}
