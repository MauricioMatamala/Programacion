package com.politecnico;

public class Biblioteca {
    private Libro[] libros;
    private int numeroLibrosAlmacenados;

    public Biblioteca(int numeroLibros){
        libros = new Libro[numeroLibros];
        numeroLibrosAlmacenados = 0;
    }

    public void insertarLibro(Libro libro){
        if (numeroLibrosAlmacenados < libros.length){
            libros[numeroLibrosAlmacenados] = libro;
            numeroLibrosAlmacenados++;
        }
    }

    public String toString(){
        int i= 0;
        String listadoLibros = "";
        for (int indiceLibro = 0; indiceLibro < numeroLibrosAlmacenados; indiceLibro++){
            Libro libro = libros[indiceLibro];
            listadoLibros += "\n=======================================\n";
            listadoLibros += "     " + libro.getTitulo().toUpperCase() + "       \n";
            listadoLibros += "Autor: " + libro.getAutor() + "\n";
            listadoLibros += "Editorial: " + libro.getEditorial() + "\n";
            listadoLibros += "Número de edición: " + libro.getNumeroEdicion() + "\n";
            listadoLibros += "ISBN: " + libro.getISBN() + "\n";
        }
        return listadoLibros;
    }
}
