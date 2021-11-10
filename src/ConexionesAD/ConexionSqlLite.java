package ConexionesAD;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConexionSqlLite {

		private static String url= "jdbc:sqlite:D:/DAM 2/PROGRAMACIÓN/Tema1/src/ConexionesAD/" ;
				 
		public static void main(String[] args) {
			
			String bd="bibliotecaej.db";
			conectar(bd);
		}
	   public static Connection conectar(String db ){
		   
	      Connection connection = null;
	      url=url+db;
	      try{
	         connection = DriverManager.getConnection(url);
	         
	            System.out.println("Conexión exitosa!");
	         
	      }
	      catch ( Exception ex ) {
	         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	         System.out.println("Error en la conexión");
	      }
		return connection;
	   }
	 
	} 

