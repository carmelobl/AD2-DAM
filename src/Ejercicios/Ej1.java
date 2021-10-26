package Ejercicios;

import java.io.File;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File arch1= new File("C:\\Users\\Alumno_FP\\Desktop\\ola1.txt");
		File arch2= new File("C:\\Users\\Alumno_FP\\Desktop\\ola2.txt");
		File dir1= new File("C:\\Users\\Alumno_FP\\Desktop\\ola1");
		File dir2= new File("C:\\Users\\Alumno_FP\\Desktop\\ola2");
		
		System.out.println("żarch1 existe?  "+arch1.exists()+" żes directorio?  "+ arch1.isDirectory());
		System.out.println("żarch2 existe?  "+arch2.exists()+" żes directorio?  "+ arch2.isDirectory());
		System.out.println("żdir1 existe?  "+dir1.exists()+" żes directorio?  "+ dir1.isDirectory());
		System.out.println("żdir2 existe?  "+dir2.exists()+" żes directorio?  "+ dir2.isDirectory());
		
		
		
	}

}