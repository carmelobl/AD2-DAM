package Ejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ObjetOutput.Libro;

public class Ej13 {

	public static void main(String[] args) {
		//creo el libro y llamo a los métodos.
		Libro l1=new Libro("1234","Las aventuras de antonio",1998);
		grabarLibro(l1);
		recuperarLibro();
	}
	public static void grabarLibro(Libro l1) {
		try {
			//defino la ruta donde voy a escribir el oobjeto
			FileOutputStream fos=new FileOutputStream("D:\\DAM 2\\PROGRAMACIÓN\\Tema1\\src\\libro.dat");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			//escribo el objeto
			oos.writeObject(l1);		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void recuperarLibro() {
		try {
			//defino la ruta de donde recupero el libro
			FileInputStream fis=new FileInputStream("D:\\DAM 2\\PROGRAMACIÓN\\Tema1\\src\\libro.dat");
			//lo encapsulo en un Objet Output Stream
			ObjectInputStream ois=new ObjectInputStream(fis);
			//almaceno el libro en un objeto libro(casteo la lectura y controlo la excepción)
			Libro LibroRecuperado=(Libro) ois.readObject();
			//imprimo el libro para comprobar que en efecto se a grabado y recuperado el libro correctamente.
			System.out.println(LibroRecuperado.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
