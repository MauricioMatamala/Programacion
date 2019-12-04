package com.politecnico.xml;

import com.politecnico.Componente;
import com.politecnico.Inventario;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.HashMap;
import java.util.Map;

public class ArchivoInventarioXML extends ArchivoXML{

	public Inventario leerInventarioXML(String nombreArchivo){
		Inventario inventario = new Inventario();
		try {
			this.abrirArchivoXML(nombreArchivo);
			XPath xPath = XPathFactory.newInstance().newXPath();
			String xpathExpr = "/inventario/componente";
			NodeList nodeList = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);
			for (int i=0; i<nodeList.getLength(); i++){
				Element elementoComponente = (Element) nodeList.item(i);
				Componente componente = new Componente(elementoComponente.getAttribute("id"));
				Integer existencias = Integer.parseInt(elementoComponente.getAttribute("existencias"));
				inventario.addExistencia(componente,existencias);
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return inventario;
	}

	public void escribirInventarioAXML(Inventario inventario, String archivoXML){
		HashMap<Componente,Integer> existencias = inventario.getExistencias();
		String stringXML = "<inventario>";
		for (Map.Entry<Componente,Integer> componenteCantidad : existencias.entrySet())
			stringXML += "<componente id=\"" + componenteCantidad.getKey().getId() + "\" cantidad=\"" + componenteCantidad.getValue() + "\"/>";
		stringXML += "</inventario>";
		escribirStringXML(stringXML,archivoXML);
	}
}
