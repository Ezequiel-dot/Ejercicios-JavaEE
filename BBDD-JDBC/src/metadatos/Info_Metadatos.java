package metadatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Info_Metadatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	mostrar_info_base_datos();
		mostrar_info_tablas();

	}
	static void mostrar_info_base_datos() {
		Connection miconexion=null;
		
		try {
			miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
		
			//obtencion metadata
			
			DatabaseMetaData datosBBDD=miconexion.getMetaData();
			
			//mostramos info base datos
			
			System.out.println("Gestor de BBDD: "+datosBBDD.getDatabaseProductName());
			System.out.println("Version del gestos: "+datosBBDD.getDatabaseProductVersion());
			System.out.println("Nombre del driver: "+datosBBDD.getDriverName());
			System.out.println("Version del driver: "+datosBBDD.getDriverVersion());

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				miconexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static void mostrar_info_tablas() {
			Connection miconexion=null;
			ResultSet rs=null;

			try {
				
				miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
				DatabaseMetaData datosBBDD=miconexion.getMetaData();
				
				System.out.println("Lista de tablas");
				
				rs=datosBBDD.getTables(null, null, "pr%", null);
				
				while(rs.next()) {
					System.out.println(rs.getString("TABLE_NAME"));
				}
				
				//Lista de columnas de productos
				
				System.out.println("");
				System.out.println("Campos de productos");
				
				rs=datosBBDD.getColumns(null, null, "productos", null);
				
				while(rs.next()) {
					System.out.println(rs.getString("COLUMN_NAME"));
				}
				
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}finally {
				try {
					miconexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
	}
}







