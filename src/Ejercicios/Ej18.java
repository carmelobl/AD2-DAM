package Ejercicios;

import ObjetOutput.Revista;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class Ej18 {

	public static void main(String[] args)throws IOException,ParserConfigurationException {
		Revista r1=new Revista("0001","Hola",2021,1);
		Revista r2= new Revista("0020","AD",2020,2);

		File archivo=new File("revistas.xml");
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.newDocument();
			doc.setXmlVersion("1.0");
			Element elRevistas=doc.createElement("listarevistas");//se crea el elemento
			doc.appendChild(elRevistas);//se posiciona como nodo raiz en el DOM
			Element elRevista=doc.createElement("revista");
			elRevistas.appendChild(elRevista);

			Element elTagCodigo=doc.createElement("codigo");
			elRevista.appendChild(elTagCodigo);
			String elCodigo= r1.getCodigo();
			elTagCodigo.appendChild(doc.createTextNode(elCodigo));

			Element elTagTitulo=doc.createElement("titulo");
			elRevista.appendChild(elTagTitulo);
			String elTitulo= r1.gettitulo();
			elTagTitulo.appendChild(doc.createTextNode(elTitulo));

			Element elTagAñopublicacion=doc.createElement("añodepublicación");
			elRevista.appendChild(elTagAñopublicacion);
			elTagAñopublicacion.appendChild(doc.createTextNode(String.valueOf(r1.getAño())));

			Element elTagNumero=doc.createElement("numero");
			elRevista.appendChild(elTagNumero);
			elTagNumero.appendChild(doc.createTextNode(String.valueOf(r1.getnumero())));

			//Se pasa al fichero
			
			doc.getAttributes();
			Source source=new DOMSource(doc); //se crea la fuente xml
			
			Result result=new StreamResult(archivo); //se forma el resultado
			Transformer transformer= TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.METHOD,"xml");
			transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			transformer.setOutputProperty("{http:xml.apache.org/xslt}indent-amount","4");
			transformer.transform(source, result);
		
			recuperar();
		}
		catch(Exception e){


		}
	}
	public static void recuperar() throws ParserConfigurationException {
		File f1 = new File("revistas.xml");
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc;
		//fichero recuperado
		try {
			doc = builder.parse(f1);
			Node listarevistas= doc.getFirstChild();
			System.out.println(listarevistas.getNodeName());
			//pruebo cogiendo el primer elemento
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
