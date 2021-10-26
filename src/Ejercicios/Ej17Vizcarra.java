package Ejercicios;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej17Vizcarra {
	public static void main(String[] args) throws IOException {
		//Declaro el fichero que voy a coger
		File fichero=new File("Aleatorio.dat");
		//Cojo un fichero aleatorio
		System.out.println(fichero.exists());
		//Si esta creado ya el fichero lo elimino para que no haya ningun problema a la hora de volver a ejecutar el programa
		if (fichero.exists()) {
			fichero.delete();
		}
		else fichero=new File("Aleatorio.dat");;
		RandomAccessFile file=new RandomAccessFile(fichero, "rw");
		escribir(file);
		leer(file);
		pedirPosicion(file);

		file.close();

	}
	//creo el método escribir para introducir los números
	public  static void escribir(RandomAccessFile file) {

		Scanner s=new Scanner(System.in);
		System.out.println("Introduce un numero para seguir o una letra para salir");

		//Creo un boolean para decirle que si es un número que lo escriba y que sino es un número que acabe el programa
		boolean numero=true;
		try {

			while(numero==true) {
				int num=s.nextInt();
				//Escribo los números que escribo en la consola.
				file.writeInt(num);

			}

		}catch(InputMismatchException e){
			//Si no es un número se para el programa
			numero=false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//Creo el método para leer los números que he introducido en el archivo
	public static void leer(RandomAccessFile file) {

		int posicion,numeroLectura;
		posicion=0;
		boolean fin = false;
		//Con este while lo que hago es que si no se acaba el programa siga leyendo y si se acaba que  muestre los números
		while (fin == false) {
			try {
				file.seek(posicion);
				numeroLectura=file.readInt();

				System.out.println(numeroLectura);
				posicion=posicion+4;

			}catch(EOFException e){
				fin=true;

			} catch (IOException e) {

				e.printStackTrace();

			}

		}


	}

	//Con este método lo que hago es sacar el valor que tiene la posición que me ha dicho el usuario
	public static void pedirPosicion(RandomAccessFile file) {
		Scanner s=new Scanner(System.in);
		System.out.println("¿Qué posicion quieres saber de los números que has introducido antes?");
		try {
			//Le paso la posición que ha dicho el usuario y le resto uno ya que estamos en un array empieza desde zero y la multiplico por 4 ya que
			//estamos guardando byts
			int posicionUsuario=s.nextInt();
			posicionUsuario=(posicionUsuario-1)*4;
			//Recorro todo el fichero para encontrar la posición
			file.seek(posicionUsuario);
			System.out.println(file.readInt());

		}catch(InputMismatchException e){

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
