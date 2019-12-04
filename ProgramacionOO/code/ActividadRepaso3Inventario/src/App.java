import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        /*Monitorizar la fabricación de productos, para que cada vez
        que se fabrica un nuevo producto se actualice el inventario
        de componentes. Tras fabricar un cierto producto, si quedan
        menos unidades de las necesarias para fabricar 10 productos,
        se debe generar un mensaje informando de la escasez de dicho
        componente.*/

        Producto p1 = new Producto("P1");
        Producto p2 = new Producto("P2");

        p1.setEspecificación(new Componente("C1",7));
        p1.setEspecificación(new Componente("C2",10));
        p1.setEspecificación(new Componente("C3",4));

        Inventario inventario = new Inventario();
        inventario.addExistencia(new Componente("C1",0),100);
        inventario.addExistencia(new Componente("C2",0),120);
        inventario.addExistencia(new Componente("C3",0),60);

        ArrayList<Componente> escasos = inventario.minimasExistencias(p1);
        while (escasos.size()==0){
            inventario.contabilizarProducto(p1);
            escasos = inventario.minimasExistencias(p1);
        }

        /*Apartado: Tras fabricar un cierto producto, si quedan
        menos unidades de las necesarias para fabricar 10 productos,
        se debe generar un mensaje informando de la escasez de dicho
        componente.*/
        if (escasos.size() > 0)
            System.out.println("NO QUEDAN EXISTENCIAS DE LOS SIGUIENTES COMPONENTES" + escasos);

        //---------------------------------------------------

        //Apartado: Mostrar el inventario por pantalla
        System.out.println(inventario);

        /* Apartado: Leer de un XML de componentes de inventario
        'inventario.xml' */

        Inventario inventario2 = new Inventario();
        inventario2.leerXML("inventario.xml");
        System.out.println(inventario2);

        inventario2.escribirXML("inventario2.xml");
    }
}
