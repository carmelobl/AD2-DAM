package Ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner (System.in);
		
		System.out.println("dame la ruta porfa plis");
		String ruta=sc.next();
		
		File dir1=new File(ruta);
		try {
			FileReader fr=new FileReader(dir1);
			int valor=fr.read();
			while(valor!=-1) {
				System.out.print((char)valor);
				valor=fr.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
