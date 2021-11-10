package Ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ej2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner (System.in);
		System.out.println("dame la ruta porfa plis");
		String ruta=sc.next();
		
		File dir1=new File(ruta);
		System.out.println("ahora la extension que quieres");
		String extension=sc.next();
		if(dir1.exists()) {
			String[] listado=dir1.list();
			for(int x=0;x<listado.length;x++) {
				String aux=listado[x];
				
				int pos=aux.lastIndexOf('.');
				String ext=aux.substring(pos+1);
				
				if(ext.contentEquals(extension)) {
					System.out.println(aux);
					
				}
		
				
				
				
			}
		};
				
	}

}
