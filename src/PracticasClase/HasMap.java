package PracticasClase;
import java.util.*;
public class HasMap {

	public static void main(String[] args) {
	HashMap<String,String> diccionario=new HashMap<String,String>();
	diccionario.put("Hola", "Saludo común en España");
	diccionario.put("Adios", "Despedida común en España");
	diccionario.put("Programación", "Doloso entrtenimiento al rededor de toto el mundo");
	
	for(String entrada:diccionario.keySet())
		System.out.println("Entrada: "+entrada +". Definición: " +diccionario.get(entrada));
	

	
	
	}

} 
