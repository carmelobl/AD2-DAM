package ConexionesAD;

import java.io.File;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.javatuples.Octet;
import org.javatuples.Quartet;
import org.javatuples.Sextet;
public class CrearBdBiblioteca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//borro file para ir probando
		File borrar =new File("D:\\DAM 2\\PROGRAMACIÓN\\Tema1\\src\\ConexionesAD\\bibliotecaej.db");
		System.out.println(borrar.delete());

		String bd="bibliotecaej.db";
		//crea la base de datos

		Connection conexion01=ConexionSqlLite.conectar(bd);
		String crearTablaLibros="CREATE TABLE Libros(codigolibro INT NOT NULL,titulo VARCHAR(60),autor VARCHAR(25),editorial VARCHAR(25),año INT,ISBN VARCHAR(25) NOT NULL UNIQUE,numeroejemplares INT,numeropaginas INT,PRIMARY KEY(codigolibro))";
		String crearTablaSocio="CREATE TABLE Socios(codigousuario INT PRIMARY KEY NOT NULL,nombre VARCHAR(15),apellidos VARCHAR(40),fechanac DATE,domicilio VARCHAR(40), telefono VARCHAR(10))";
		String crearTablaPrestamo="CREATE TABLE Prestamos(codigo INT NOT NULL,codigosocio INT NOT NULL,fechainicio DATE,fechafin DATE,FOREIGN KEY(codigo) REFERENCES Libros(codigolibro),FOREIGN KEY(codigosocio) REFERENCES Socios(codigosocio),PRIMARY KEY(codigo,codigosocio))";

		///////CREO PREVIO A INSERCIÓN
		//LIBROS
		Octet <Integer,String,String,String,Integer,String,Integer,Integer> auxLibro= new Octet <Integer,String,String,String,Integer,String,Integer,Integer> (002,"Pin y Pon","Vizcarra","Anaya", 2005,"123456123B",100,121);
		Octet<Integer,String, String,String,Integer,String,Integer,Integer> auxLibro1= new Octet <Integer,String, String,String,Integer,String,Integer,Integer> (003,"Hola","Carmelo","Anaya",2021,"1234R",3,41);
		//ARRAY LIBRO
		ArrayList<Octet> aray = new ArrayList<Octet>();
		aray.add(auxLibro);
		aray.add(auxLibro1);

		//SOCIO
		///cambiar puto valueof date
		Date f=new Date(2958648027000L);
		Date f1=new Date(1810638427000L);
		Sextet<Integer, String, String, Date, String, String> auxSocio=new Sextet<Integer, String, String, Date, String, String> (005,"Alejandro","Vizcarra",f,"Jaca","656456456");
		Sextet<Integer, String, String, Date, String, String> auxSocio1=new Sextet<Integer, String, String, Date, String, String>(02,"Carmelo","Buisac",f1,"C/San Alberto","644532134");
		ArrayList<Sextet> araySocio = new ArrayList<Sextet>();
		araySocio.add(auxSocio);
		araySocio.add(auxSocio1);

		//PRESTAMO
		Date p=new Date(2958648027000L);
		Date p1=new Date(1242644827000L);
		Date p2=new Date(2958648027000L);
		Date p3=new Date(1810638427000L);
		Quartet<Integer,Integer, Date, Date> auxPrestamo=new Quartet<Integer, Integer, Date, Date>(001, 005, p, p1);
		Quartet<Integer, Integer, Date, Date> auxPrestamo1=new Quartet<Integer, Integer, Date, Date>(02, 02, p2, p3);
		ArrayList<Quartet> arayPrestamo=new ArrayList<Quartet>();
		arayPrestamo.add(auxPrestamo);
		arayPrestamo.add(auxPrestamo1);

		try {
			//crea base de datos
			Statement crearBD=conexion01.createStatement();
			crearBD.execute(crearTablaLibros);
			crearBD.execute(crearTablaSocio);
			crearBD.execute(crearTablaPrestamo);

			//INSERTO LIBROS
			PreparedStatement insertarLibro=conexion01.prepareStatement("INSERT INTO Libros VALUES (?,?,?,?,?,?,?,?)");
			for(int w=0;w<aray.size();w++) {
				int i=1;
				int j=0;
				insertarLibro.setInt(i, (int) aray.get(w).getValue(j));
				insertarLibro.setString(++i, (String) aray.get(w).getValue(++j));
				insertarLibro.setString(++i, (String) aray.get(w).getValue(++j));
				insertarLibro.setString(++i, (String) aray.get(w).getValue(++j));
				insertarLibro.setInt(++i,(int) aray.get(w).getValue(++j));
				insertarLibro.setString(++i, (String) aray.get(w).getValue(++j));
				insertarLibro.setInt(++i,(int) aray.get(w).getValue(++j));
				insertarLibro.setInt(++i,(int) aray.get(w).getValue(++j));
				insertarLibro.executeUpdate();
			}

			//INSERTO SOCIOS
			PreparedStatement insertarSocio=conexion01.prepareStatement("INSERT INTO Socios VALUES (?,?,?,?,?,?)");
			for(int w=0;w<araySocio.size();w++) {
				int i=1;
				int j=0;
				insertarSocio.setInt(i, (int) araySocio.get(w).getValue(j));
				insertarSocio.setString(++i, (String) araySocio.get(w).getValue(++j));
				insertarSocio.setString(++i, (String) araySocio.get(w).getValue(++j));
				insertarSocio.setDate(++i, (Date) araySocio.get(w).getValue(++j));
				insertarSocio.setString(++i, (String) araySocio.get(w).getValue(++j));
				insertarSocio.setString(++i, (String) araySocio.get(w).getValue(++j));
				insertarSocio.executeUpdate();
			}

			//INSERTO LIBROS
			PreparedStatement insertarPrestamo=conexion01.prepareStatement("INSERT INTO Prestamos VALUES (?,?,?,?)");
			for(int w=0;w<arayPrestamo.size();w++) {
				int i=1;
				int j=0;
				insertarPrestamo.setInt(i, (int) arayPrestamo.get(w).getValue(j));
				insertarPrestamo.setInt(++i, (int) arayPrestamo.get(w).getValue(++j));
				insertarPrestamo.setDate(++i, (Date) arayPrestamo.get(w).getValue(++j));
				insertarPrestamo.setDate(++i, (Date) arayPrestamo.get(w).getValue(++j));
				insertarPrestamo.executeUpdate();
			}


			//·     Listado de libros prestados actualmente.

			ResultSet rsFecha=crearBD.executeQuery("SELECT * FROM Prestamos");

			while (rsFecha.next()) {	
				Date x=rsFecha.getDate("fechafin");
				Calendar hoyaux=Calendar.getInstance();
				Date hoy=new Date(hoyaux.getTimeInMillis());
				if(x.compareTo(hoy)>0) {
					System.out.print("Libro prestado: Codigo: "+rsFecha.getInt("codigo")+"  titulo: ");
					ResultSet rsTituloLibro=crearBD.executeQuery("SELECT titulo FROM Libros where codigolibro= "+rsFecha.getInt("codigo"));
					System.out.println(rsTituloLibro.getString("titulo"));
					rsTituloLibro.close();
				}
			}
			rsFecha.close();

			//·     Número de libros prestados a un socio determinado del socio 5
			
			ResultSet rsPrestamos=crearBD.executeQuery("SELECT * FROM Prestamos where codigosocio=5");
			int cantidad=0;
			while(rsPrestamos.next()) {
				cantidad++;
			}
			System.out.println("Libros prestados a este cliente: "+cantidad);
			rsPrestamos.close();

			//·     Libros que han superado la fecha de fin de préstamo.
			ResultSet rsYaPrestado=crearBD.executeQuery("SELECT * FROM Prestamos");

			while (rsYaPrestado.next()) {	
				Date x=rsYaPrestado.getDate("fechafin");
				Calendar hoyaux=Calendar.getInstance();
				Date hoy=new Date(hoyaux.getTimeInMillis());
				if(x.compareTo(hoy)<0) {
					System.out.println("Libros superando fecha fin prestado: Codigo: "+rsYaPrestado.getInt("codigo")+"  titulo: ");
				}
			}
			rsYaPrestado.close();
			
			//·     Socios que tienen libros que han superado la fecha de fin de préstamo
			
			ResultSet rsSocios=crearBD.executeQuery("SELECT * FROM Prestamos");
			
			while (rsSocios.next()) {	
				Date x=rsSocios.getDate("fechafin");
				Calendar hoyaux=Calendar.getInstance();
				Date hoy=new Date(hoyaux.getTimeInMillis());
				if(x.compareTo(hoy)<0) {
					System.out.println("Socio que ha superado la fecha de prestamo= "+rsSocios.getInt("codigosocio"));
				}
			}
			



			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
