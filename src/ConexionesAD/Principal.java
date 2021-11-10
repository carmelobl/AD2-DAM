package ConexionesAD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {

		try {
			Connection miConexion=Prueba01.Conectar();
			PreparedStatement stnt= miConexion.prepareStatement("select * from personas1");
			ResultSet r=stnt.executeQuery();
			while(r.next()) {
				System.out.println("Nombre: "+r.getString("nombre"));
				System.out.println("Edad: "+r.getString("edad"));
			}
		}catch(SQLException e) {
			System.out.println("Excepción "+e);
		}
	}
}




