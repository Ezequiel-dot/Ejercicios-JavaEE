package procesoAlmacenado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class actualizaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n_Precio=Integer.parseInt(JOptionPane.showInputDialog("Introduce precio"));
		String n_Articulo=JOptionPane.showInputDialog("Introduce N° articulo");

		try {
			
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			CallableStatement miSentencia=conexion.prepareCall("{call ACTUALIZA_PROD(?, ?)}");
			miSentencia.setInt(1, n_Precio);
			miSentencia.setString(2, n_Articulo);
			
			miSentencia.execute();
			
			System.out.println("Actualizado correctamente");
			
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
