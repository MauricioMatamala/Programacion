import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientesCSVReader {
    private String nombreArchivo;
    public ClientesCSVReader(){
        nombreArchivo = "personas.csv";
    }

    public ArrayList<Persona> getClientes(){
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            File file = new File("clientes.csv");
            Scanner sc = new Scanner(file);
            String lineaClientes = sc.nextLine();
            String[] arrayClientes = lineaClientes.split(";");
            for (int i=0; i<arrayClientes.length;i++)
                personas.add(new Persona(arrayClientes[i]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return personas;
    }


}
