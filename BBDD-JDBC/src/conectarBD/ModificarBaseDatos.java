package conectarBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModificarBaseDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//1.CREAR CONECCION
			Connection miconexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			
			//2.CREAR OBJETO STATEMENT
			Statement miStatement= miconexion.createStatement();
			
		//	String inserta="INSERT INTO PRODUCTOS(CÓDIGOARTÍCULO,NOMBREARTÍCULO,PRECIO) VALUES ('AR77','PANTALÓN',25.35)";
			
		//	String inserta="UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";

			String inserta="DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77'";

			miStatement.executeUpdate(inserta);
			
			System.out.println("Datos actualizados correctamente");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
