package transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class transaccion_productos {

	public static void main(String[] args) {
		
	Connection miConexion=null;
	
	try{					
			
		miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");				
		
		miConexion.setAutoCommit(false);
		
		Statement miStatement =miConexion.createStatement();
		
	    String instruccionSql_1="DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN ='ITALLIA'";
	    String instruccionSql_2="DELETE FROM PRODUCTOS WHERE PRECIO>300";	    
	    String instruccionSql_3="UPDATE PRODUCTOS SET PRECIO=PRECIO*1.15";
	    
	    boolean ejec=ejecutar_transaccion();

	    if(ejec) {
	    miStatement.executeUpdate(instruccionSql_1);
	    miStatement.executeUpdate(instruccionSql_2);
	    miStatement.executeUpdate(instruccionSql_3);
	    miConexion.commit();
	    System.out.println("Datos INSERTADOS correctamente");
	    }else {
	    	System.out.println("No se realizo ningun cambio");
	    }
	    
	}catch(Exception e){
		e.printStackTrace();
		try {
			miConexion.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Algo salio mal y no se realizo cambio alguno");
		}
	}
	static boolean ejecutar_transaccion() {
		String ejecucion=JOptionPane.showInputDialog("Ejecutamos transaccion?");
		
		if(ejecucion.equals("Si"))return true;
		
		else return false;
		
	}
}







