package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
	Connection conexion=null;
	public conexion() {
		
	}
	
	public Connection dameConexion() {
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
}
