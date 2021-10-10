package conectarBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//1. CREAR CONECCION
			
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
			//2. PREPARAR CONSULTA
			
			PreparedStatement statement=conexion.prepareStatement("SELECT NOMBREARTÍCULO,SECCIÓN,PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?");
			
			//3. ESTABLECER PARAMETROS DE CONSULTA
			
			statement.setString(1, "deportes");
			statement.setString(2, "USA");
			
			//4. EJECUTAR Y RECORRER CONSULTA
			
			ResultSet rs=statement.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			rs.close();
			
			//REUTILIZAR CODIGO
			
			System.out.println("PARTE 2");

			statement.setString(1, "cerámica");
			statement.setString(2, "china");
			
			rs=statement.executeQuery();
			
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
