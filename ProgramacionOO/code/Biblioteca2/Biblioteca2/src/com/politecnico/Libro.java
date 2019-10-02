package com.politecnico;

public class Libro {
    String titulo, autor, editorial, ISBN;
    int numeroEdicion;

    public Libro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public Libro(String titulo,
                 String autor,
                 String editorial,
                 int numeroEdicion,
                 String ISBN){
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.numeroEdicion = numeroEdicion;
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }
}
