package com.politecnico;

public class Componente {
    private String id;

    public Componente(String id) {
        this.id = id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Componente otroComponente = (Componente) obj;
        return id.equals(otroComponente.getId());
    }

    @Override
    public String toString() {
        return "Componente{" +
                "id='" + id + '\'' +
                '}';
    }
}
