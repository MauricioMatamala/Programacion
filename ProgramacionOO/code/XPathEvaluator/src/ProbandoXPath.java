import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathExpressionException;

public class ProbandoXPath {
	public static void main(String[] args) {
		XPathEvaluator eval = new XPathEvaluator("songlist.xml");
		try {
			NodeList nodeSet = eval.evaluateXPath("/listas/lista");
			printNodeList(nodeSet, 0);

			System.out.println("==================================================================");
			System.out.println("                   UNA SEGUNDA ESTRATEGIA");
			System.out.println("==================================================================");

			/* NOTA:
				En el ejemplo anterior se utilizan los métodos item() y getChildNodes() para navegar por el NodeSet.
				Una forma alternativa de obtener los nodos de interés es mediante el método getElementsByTagName.
				En el siguiente fragmento se imprimen las canciones de las listas.
		    */
			printNodesByTagName(nodeSet);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}

	/*
		Acceso a los nodos dentro del NodeList utilizando los siguientes métodos:
			- item(i) -> devuelve un Nodo
			- getChildNodes() -> devuelve un NodeList con los nodos hijos.
	 */

	public static void printNodeList(NodeList listaDeNodos, int nivelProfundidad){
		if (listaDeNodos !=  null){
			for (int i = 0; i < listaDeNodos.getLength(); i++) {
				System.out.println("----------------------------");
				Node n = listaDeNodos.item(i);
				printInfoNodo(n, nivelProfundidad);
				printAtributosNodo(n,nivelProfundidad);
				printNodeList(n.getChildNodes(), nivelProfundidad + 1);
			}
		}
	}

	public static void printNodesByTagName(NodeList nodeSet){
		for (int i=0; i<nodeSet.getLength(); i++){
			Element e = (Element) nodeSet.item(i);
			NodeList canciones = e.getElementsByTagName("cancion");
			for (int j=0; j<canciones.getLength(); j++){
				System.out.println("--------------------------------");
				printInfoNodo(canciones.item(j),0);
				printAtributosNodo(canciones.item(j),0);
				System.out.println("CONTENIDO: "+canciones.item(j).getTextContent());
			}
		}
	}

	private static void printInfoNodo(Node n, int nivelProfundidad){
		System.out.println(getEspacios(nivelProfundidad) + getTipoNodo(n) + n.getNodeName());
	}

	/*
		Dado un nodo, se obtienen sus atributos. Si hay alguno (n.getAttributes() != null) se imprime su contenido con toString()
	 */
	private static void printAtributosNodo(Node n, int nivelProfundidad){
		if (n!=null){
			NamedNodeMap atributos = n.getAttributes();
			if (atributos != null)
				for (int i=0; i<atributos.getLength(); i++)
					System.out.println(getEspacios(nivelProfundidad) + "ATRIBUTO:" + atributos.item(i).toString());
		}
	}

	private static String getTipoNodo(Node n){
		if (n.getNodeType() == Element.ELEMENT_NODE)
			return "NODO ELEMENTO: ";
		else if (n.getNodeType() == Element.TEXT_NODE)
			return "NODO TEXTO : ";
		else if (n.getNodeType() == Element.ATTRIBUTE_NODE)
			return "NODO ATRIBUTO: ";
		else
			return "NODO: ";
	}

	private static String getEspacios(int numeroEspacios){
		String espacios = "";
		for (int i=0; i<numeroEspacios; i++) espacios += "\t";
		return espacios;
	}
}
