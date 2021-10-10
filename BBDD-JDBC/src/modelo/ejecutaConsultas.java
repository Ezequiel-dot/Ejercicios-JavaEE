package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ejecutaConsultas {
	
	public ejecutaConsultas() {
		micon=new conexion();
	}
	
	public ResultSet filtrarBBDD(String seccion,String pais) {
		
		Connection conecta=micon.dameConexion();
		res=null;
		
		try {
		
		if(!seccion.equals("Todos") && pais.equals("Todos")){

			enviaConsultaProducto=conecta.prepareStatement(consulta);
			
			enviaConsultaProducto.setString(1,seccion);
			
			res=enviaConsultaProducto.executeQuery();
			//solo elige pais
			
			}else if(seccion.equals("Todos") && !pais.equals("Todos")) {
				enviaConsultaProducto2=conecta.prepareStatement(consulta2);
				
				enviaConsultaProducto2.setString(1,pais);
				
				res=enviaConsultaProducto2.executeQuery();
			}
			// elije ambas
			else if(!seccion.equals("Todos") && !pais.equals("Todos")) {
				enviaConsultaProducto3=conecta.prepareStatement(consulta3);
				
				enviaConsultaProducto3.setString(1,seccion);
				enviaConsultaProducto3.setString(2,pais);
				res=enviaConsultaProducto3.executeQuery();
			}else if(seccion.equals("Todos") && pais.equals("Todos")){
				enviaConsultaProducto4=conecta.prepareStatement(consulta4);
				
				
				res=enviaConsultaProducto4.executeQuery();
			}
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
		
	}
	private conexion micon;
	private ResultSet res;
	private PreparedStatement enviaConsultaProducto;
	private final String consulta="SELECT NOMBREART�CULO,SECCI�N,PRECIO,PA�SDEORIGEN "
			+ "FROM PRODUCTOS WHERE SECCI�N=?"; 
	
	private PreparedStatement enviaConsultaProducto2;
	private final String consulta2="SELECT NOMBREART�CULO,SECCI�N,PRECIO,PA�SDEORIGEN "
			+ "FROM PRODUCTOS WHERE PA�SDEORIGEN=?"; 
	
	private PreparedStatement enviaConsultaProducto3;
	private final String consulta3="SELECT NOMBREART�CULO,SECCI�N,PRECIO,PA�SDEORIGEN "
			+ "FROM PRODUCTOS WHERE SECCI�N=? AND PA�SDEORIGEN=?"; 
	
	private PreparedStatement enviaConsultaProducto4;
	private final String consulta4="SELECT NOMBREART�CULO,SECCI�N,PRECIO,PA�SDEORIGEN "
			+ "FROM PRODUCTOS"; 
}
