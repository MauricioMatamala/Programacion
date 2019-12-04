package com.politecnico.xml;

import com.politecnico.Componente;
import com.politecnico.Producto;
import com.politecnico.Productos;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArchivoProductosXML extends ArchivoXML{

	public Productos leerProductosXML(String nombreArchivo){
		Productos productos = new Productos();
		try {
			this.abrirArchivoXML(nombreArchivo);
			XPath xPath = XPathFactory.newInstance().newXPath();
			String xpathExpr = "/productos/producto";
			NodeList listaNodosProducto = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);
			for (int i=0; i<listaNodosProducto.getLength(); i++)
				productos.addProducto(getProducto(listaNodosProducto.item(i)));
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return productos;
	}

	public void escribirInventarioAXML(Productos productos, String archivoXML){
		ArrayList<Producto> listaProductos = productos.getProductos();
		String stringXML = "<productos>";
		for (Producto producto: listaProductos){
			stringXML += "<producto id=\"" + producto.getId() + "\">";
			HashMap<Componente,Integer> especificaciones = producto.getEspecificaciones();
			for (Map.Entry<Componente,Integer> componenteCantidad : especificaciones.entrySet())
				stringXML += "<componente id=\"" + componenteCantidad.getKey() + "\" cantidad=\"" + componenteCantidad.getValue() + "\"/>";
			stringXML += "</producto>";
		}
		stringXML += "</productos>";
		escribirStringXML(stringXML,archivoXML);
	}

	private Producto getProducto(Node nodoProducto) {
		Element elementoProducto = (Element) nodoProducto;
		Producto producto = new Producto(elementoProducto.getAttribute("id"));
		NodeList listaNodosComponente = elementoProducto.getElementsByTagName("componente");
		for (int j=0; j<listaNodosComponente.getLength(); j++){
			Element elementoComponente = (Element) listaNodosComponente.item(j);
			Componente componente = new Componente(elementoComponente.getAttribute("id"));
			Integer cantidad = Integer.parseInt(elementoComponente.getAttribute("cantidad"));
			producto.addEspecificación(componente,cantidad);
		}
		return producto;
	}
}
