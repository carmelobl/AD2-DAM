package Ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ej2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner (System.in);
		System.out.println("dame la ruta porfa plis");
		String ruta=sc.next();
		
		File dir1=new File(ruta);
		
		if(dir1.exists()&&dir1.isDirectory()) {
			File[] listado=dir1.listFiles();
			for(int x=0;x<listado.length;x++) {
				System.out.println(listado[x].getName());
			}
		}
				
	}

}
