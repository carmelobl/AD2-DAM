package Ejercicios;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej17{ public static void main(String[] args) throws IOException {
	//borro el archivo que puede existir en mi ruta
	//si es la primera vez que lo ejecutas en eclipse te va a funcionar independientemente si el archivo existe o no
	try {Files.deleteIfExists(Paths.get("Aleatorio.dat"));
		System.out.println("lo hemos podido borrar");
	} catch (Exception e) {
		System.out.println("no hemos podido pero si cierras elcipse y lo vuelves abrir si :)");
		// TODO: handle exception
	}

	//Creo el archivo donde voy a guardar los n�meros
	File fichero=new File("Aleatorio.dat");

	RandomAccessFile file=new RandomAccessFile(fichero, "rw");
	//Si existe el archivo lo elimino para que no haya ningun problema que haya podido suceder antes
	
	escribeNum(file);
	
	leer(file);
	
	pedirPos(file);
	file.close();
}

	//creo la m�todo para que escriba n�meros
public static void escribeNum(RandomAccessFile file) {
	
	Scanner s=new Scanner(System.in);

	//Pido al usuario que introduzca los n�meros

	System.out.println("Introduce un numero para seguir o una letra para salir");

	//Creo un boolean para saber si el usuario ha introducido un n�mero o una letra
	boolean numero=true;
	try {
		//Con el m�todo while hago que mientras el n�mero introducido sea un n�mero lo escriba
		// y pase al siguiente
		while(numero==true) {
			int num=s.nextInt();
			file.writeInt(num);

		}

	}catch(InputMismatchException e){
		numero=false;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	//creo la m�todo de lectura
public static void leer(RandomAccessFile file) {
	int pos,numeroLectura;
	pos=0;
	//creo un booleano para meterlo dentro del bucle y mientras este no cambie a true no saldr� del bucle while
	boolean fin = false;
	while (fin == false) {
		try {
			//apunto a la posici�n "pos" del archivo
			file.seek(pos);
			//almaceno lo que hay en ese archivo en un "int"
			numeroLectura=file.readInt();
			//imprimo numeroLectura
			System.out.println(numeroLectura);
			//cambio la posici�n a "pos"+4 que es donde se encuentra el siguiente dato
			pos=pos+4;

		}
		//controlo la excepci�n de que no se acabe el archivo.
		catch(EOFException e){
			fin=true;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
	//creo una m�todo para imprimir el contenido de una posicion que pide el usuario.
public static void pedirPos(RandomAccessFile file) {
		Scanner s=new Scanner(System.in);
		System.out.println("que posicion quieres?");
		try {
			//almaceno el n�mero de posici�n que quiere el usuario.
			int posicionUsuario=s.nextInt();
			//como intuyo que para el usuario la posici�n 1 es la primera, le resto uno ya que el archivo 
			//empieza en la posici�n 0, lo multiplico por 4 ya que los bytes se leen de 4 en 4.
			posicionUsuario=(posicionUsuario-1)*4;//8
			// apunto el archivo al byte que quiere el usuario y lo imprimo 
			
			file.seek(posicionUsuario);
			System.out.println(file.readInt());
			
		}catch(InputMismatchException e){

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}

