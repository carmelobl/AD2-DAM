package Ejercicios;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej7 {
	//Practica de Carmelo Buisac
	
	//**********continuación del ej 4**********

	public static void main(String[] args) {
		
		File almacenaje=new File("pruebas.txt");
		//al crear un nuevo archivo y no leerlo sobrescribo el archivo que pudiera haber.
		ArrayList<String> frases=new ArrayList<String>();
		System.out.println("Introduce datos a almacenar");
		LlenarArray(frases);
		GrabarEnTexto(almacenaje, frases);
		LeerLoQueHay(almacenaje);

		}
	
	private static void  LlenarArray(ArrayList<String> frases){
		//en este método voy llenando el array ded una forma peculiar, sin añadir palabras que ya contenia el array,
		//he tenido un poco de problema a la hora de ver si estaban repetidas porque primero añadia la palabra y 
		//luego comprobaba si estaba,lo he solucionado cuando me he dado cuenta.
		//Primero añado la primera palabra fuera del bucle y añado la primera palabra, a continuacion abro la condicion "while" 
		//para comparar las palabra que quiere introducir y si esta palabra es fin se deja de añadir palabras al programa.
		Scanner sc=new Scanner(System.in);
		String frase = "inicializado";
		frase=sc.nextLine();
		frases.add(frase);
		
		while(!frase.equals("fin")) {
			System.out.println("Escribe *fin* para finalizar");
			frase=sc.nextLine();
			
		
				if(frases.contains(frase)) {
					System.out.println("está repetida");
					frases.remove(frases.size()-1);
				}
				if(frase.contains("fin"))
						System.out.println("chao pescao");
				else {
					frases.add(frase);
					
					System.out.println("frase "+ frase+" grabada");
				}	
		
		}
	}

	private static void GrabarEnTexto(File f1,ArrayList<String>frases){
		//Para grabar el texto  uso la clase file writer, recorro el array y grabo las palabras una por una
		try {
			FileWriter fw= new FileWriter(f1);
			for(int x=0;x<frases.size();x++) {
				fw.write(frases.get(x));
				fw.write("\n");
				
			}
			fw.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void LeerLoQueHay(File f1) {
		
		//Uso el BufferedReaderCorrectamente para que lea, para que no se me coma las lineas creo un auxiliar
		try {
			FileReader fr=new FileReader(f1);
			BufferedReader bf=new BufferedReader(fr);
			String aux;
			while((aux=bf.readLine())!=null)
				System.out.println(aux);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
//Practica de Carmelo Buisac