package Ejercicios;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Saxhandler extends DefaultHandler{
	private ArrayList <Alumno>versiones=new ArrayList();
	private Alumno alumno; 
	private StringBuilder buffer=new StringBuilder();

	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		switch(qName) {
		case "listadealumnos":
			break;
		case "alumno":
			alumno=new Alumno();
			versiones.add(alumno);
			
			break;
		case "nombre":
			buffer.delete(0, buffer.length());
			break;
		case "edad":
			break;
		}
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		switch(qName) {
		case "nombre":
			alumno.setNombre(buffer.toString());
			
			break;
		case "edad":
			break;
		case "alumno":
			alumno=new Alumno();
			versiones.add(alumno);
			
			break;
		case "listadealumnos":
			break;
		}
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		buffer.append(ch, start, length);
		
		super.characters(ch, start, length);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Alumno> getAlumnos() {
		// TODO Auto-generated method stub
		return versiones;
	}

}
