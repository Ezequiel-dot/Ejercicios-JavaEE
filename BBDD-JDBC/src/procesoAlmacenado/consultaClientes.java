package procesoAlmacenado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class consultaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			CallableStatement miSentencia=conexion.prepareCall("{call MUESTRA}");
			ResultSet rs=miSentencia.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			rs.close();

			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
