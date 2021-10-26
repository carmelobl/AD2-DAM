package Ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class dsfa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Files.deleteIfExists(Paths.get("D:\\DAM 2\\PROGRAMACIÓN\\Tema1\\Aleatorio.dat"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
