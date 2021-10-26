package Ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Ej11b {

	public static void main(String[] args) {
		copiaSeguridad();
	}


	public static void copiaSeguridad() {
		//cogemos el directorio a copiar
		File dir=new File("data");	
	
		//cojo la fecha actual y la formateo a algo legible
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH-mm-ss z");

		//destino
		File dir2=new File("data\\dataBackup"+formatter.format(date));
		//creo la carpeta, si ya existe la machaco

		dir2.mkdir();
		//recorro cada archivo que tiene la carpeta a copiar
		for(File archivo:dir.listFiles()) {
			//compruebo que sea archivo y no la misma carpeta de backup
			if(archivo.isFile()) {
				//cojo la ruta donde escribiré los datos
				String rutaa=dir2.getPath()+"\\"+archivo.getName();

				try {
					//lo metemos en un FileInputStream para ir recogiendo datos
					FileInputStream fis=new FileInputStream(archivo);
					FileOutputStream fos= new FileOutputStream(rutaa);
					//almaceno el archivo en un array de bytes para escribirlo
					byte[] array=fis.readAllBytes();

					fos.write(array);
					fos.close();
					fis.close();
					//controlo los posibles fallos
				} catch (FileNotFoundException e) {
					System.out.println("error actual");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



			}//fin for

		}
	}

}
