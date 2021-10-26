package ObjetOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//meterlo en clases y acceder desde una clase 3
public class Almacenar {

	public static void main(String[] args) {
		//creo un libro y una revista
		Libro l1=new Libro("1234", "las aventuras de vizcarra", 2004);
		Revista r1=new Revista("1235", "autodoc", 2002, 5);
		grabarLibro(l1);
		grabarRevista(r1);

	}
	public static void grabarLibro(Libro l1) {
		try {
			
			FileOutputStream fos=new FileOutputStream("D:\\DAM 2\\PROGRAMACIÓN\\Tema1\\src\\libro.dat");
			
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(l1);		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public static void grabarRevista(Revista r1) {
		try {
			FileOutputStream fos=new FileOutputStream("D:\\DAM 2\\PROGRAMACIÓN\\Tema1\\src\\revista.dat");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			FileInputStream fis = new FileInputStream("D:\\DAM 2\\PROGRAMACIÓN\\Tema1\\src\\revista.dat");
			oos.writeObject(r1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}



