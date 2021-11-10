package ConexionesAD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Prueba01 {
	private static final String url="jdbc:mysql://localhost:3306/acceso";
	private static final String usuario="Carmelo";
	private static final String  clave="alumno";
	public static void main(String[] args) {
		Conectar();
	}
	public static Connection  Conectar() {
		
		Connection conexion=null;
		
		try {
			conexion=DriverManager.getConnection(url, usuario,clave);
			System.out.println("muy bien");
		} catch (SQLException e) {
			System.out.println("mal");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return conexion;
		

	}

}
