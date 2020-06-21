import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVClientesReader {
    private String nombreArchivo;
    public CSVClientesReader(){
        nombreArchivo = "clientes.csv";
    }

    public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try {
            File archivo = new File(nombreArchivo);
            Scanner lectorCSV = new Scanner(archivo);
            String lineaClientes = lectorCSV.nextLine();
            String nombresClientes[] = lineaClientes.split(";");
            for (int i=0; i<nombresClientes.length; i++){
               
               // Código aquí
               
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }
}
