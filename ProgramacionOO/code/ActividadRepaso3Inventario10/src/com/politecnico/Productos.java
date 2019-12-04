package com.politecnico;

import java.util.ArrayList;

public class Productos {
	ArrayList<Producto> productos;

	public Productos(ArrayList<Producto> productos){
		this.productos = productos;
	}

	public Productos(){
		productos = new ArrayList<>();
	}

	public Producto getProductoById(String id){
		Producto patrónDeBúsqueda = new Producto(id);
		return productos.get(productos.indexOf(patrónDeBúsqueda));
	}

	public void addProducto(Producto producto){
		productos.add(producto);
	}

	public ArrayList<Producto> getProductos(){
		return productos;
	}
}
