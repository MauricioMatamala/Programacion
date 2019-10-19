package com.politecnico.posicion;

public class Vector extends Coordenadas {
	private String descripcion;

	public Vector(int x, int y){
		super(x,y);
	}

	public Vector(int x, int y, String descripcion){
		super(x,y);
		setDescripcion(descripcion);
	}

	public void invertir(){
		setX(-getX());
		setY(-getY());
	}

	public Vector clone(){
		return new Vector(getX(),getY(),getDescripcion());
	}

	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}

	public String getDescripcion(){
		return descripcion;
	}
}
