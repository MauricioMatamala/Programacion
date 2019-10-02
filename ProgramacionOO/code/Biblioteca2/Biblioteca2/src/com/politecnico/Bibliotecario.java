package com.politecnico;

public class Bibliotecario {
    static AttCliente atencionCliente;
    static Biblioteca biblioteca;

    static void realizarTareaDeBiblioteca(int accion){
        switch (accion){
            case AttCliente.OP_INTRODUCIR_LIBRO:
                Libro nuevoLibro = atencionCliente.preguntarDatosNuevoLibro();
                biblioteca.insertarLibro(nuevoLibro);
                break;
            case AttCliente.OP_MOSTRAR_LIBROS:
                atencionCliente.mostrarListadoLibros(biblioteca);
        }
    }

    public static void main(String[] args) {
        atencionCliente = new AttCliente();
        biblioteca = new Biblioteca(100);
        int accion = AttCliente.OP_NO_DEFINIDA;
        do {
            accion = atencionCliente.preguntarOpciones();
            if (accion != AttCliente.OP_TERMINAR)
                realizarTareaDeBiblioteca(accion);
        } while (accion != AttCliente.OP_TERMINAR);
    }
}
