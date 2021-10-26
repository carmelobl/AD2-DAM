package Ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import PracticasClase.HasMap;

public class Ej10 {

	public static void main(String[] args) {
		//creamos un has map para almacenar el caracter en primer espacio y en el segundo el numero de veces
		HashMap <String,Integer> numChars=new HashMap <String,Integer>() ;
		//le doy la ruta del fichero al que accede
		File archivo=new File("caracteres.txt");
		contarLetras(numChars,archivo);
		muestraLetras(numChars);

	}

	

	public static void  contarLetras(HashMap <String,Integer> m,File arch) {
		//controlo que el archivo exista y que se encuentre en el sitio
		try {
			int valor=0;
			FileReader fr =new FileReader(arch);
			//recorro el archivo hasta que llegue al final
			while((valor = fr.read())!=-1) {
				String letraKey=String.valueOf((char)valor);
				//si el valor es menor que 32 no lo cuento por que solo quiero contar las letras
				if(valor>32) {
					//miro que no este repetido y sino almacena una nueva entrada
					if(!m.containsKey(letraKey)){

						m.put(letraKey,1);
					}
					//si ya está la letra le sumo uno
					else {
						m.put(letraKey, m.get(letraKey)+1);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void muestraLetras(HashMap<String, Integer> numChars) {
		//recorro el hash map y lo imprimo
		for(String entrada:numChars.keySet())
			System.out.println("Letra: "+entrada +". Veces: " +numChars.get(entrada));

	}
}
