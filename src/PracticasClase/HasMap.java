package PracticasClase;
import java.util.*;
public class HasMap {

	public static void main(String[] args) {
	HashMap<String,String> diccionario=new HashMap<String,String>();
	diccionario.put("Hola", "Saludo com�n en Espa�a");
	diccionario.put("Adios", "Despedida com�n en Espa�a");
	diccionario.put("Programaci�n", "Doloso entrtenimiento al rededor de toto el mundo");
	
	for(String entrada:diccionario.keySet())
		System.out.println("Entrada: "+entrada +". Definici�n: " +diccionario.get(entrada));
	

	
	
	}

} 
