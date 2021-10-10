package conectarBD;

import java.sql.*;

public class Conecta_Pruevas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//1.CREAR CONECCION
			Connection miconexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
			//2.CREAR OBJETO STATEMENT
			Statement miStatement= miconexion.createStatement();
			
			//3.EJECUTAR SQL
			ResultSet miresulset=miStatement.executeQuery("SELECT * FROM PRODUCTOS");
			
			//4. LEER EL RESULSET
			while(miresulset.next()) {
				System.out.println(miresulset.getString(3)+" / "+miresulset.getString(1)+" / "+miresulset.getInt("PRECIO")
				+" / "+miresulset.getString("FECHA"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}   
	}
}




