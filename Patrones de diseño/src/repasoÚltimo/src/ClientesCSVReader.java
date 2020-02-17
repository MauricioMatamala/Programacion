import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ClientesCSVReader {
    private String nombreArchivo;
    public ClientesCSVReader(){
        nombreArchivo = "clientes.csv";
    }

    public void getClientes(){
        try {
            File file = new File("clientes.csv");
            Scanner sc = new Scanner(file);
            String lineaClientes = sc.nextLine();
            String[] arrayClientes = lineaClientes.split(";");
            for (int i=0; i<arrayClientes.length;i++)
                System.out.println(arrayClientes[i]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
