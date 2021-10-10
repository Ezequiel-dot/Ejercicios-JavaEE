package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CargarMenus {
	
	public CargarMenus() {
	
		miconexion= new conexion();
	
	}
	
	public String ejecutaConsultas() {
		producto miProducto=null;
		
		Connection miCon=miconexion.dameConexion();
		
		try {
			
			Statement mistatement=miCon.createStatement();
			rs=mistatement.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
			
			Statement paises=miCon.createStatement();
			rs2=paises.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");
			
			miProducto=new producto();
				
			miProducto.setSeccion(rs.getString(1));
			miProducto.setpOrigen(rs2.getString(1));
			 
			rs2.close();
			rs.close();
			miCon.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return miProducto.getSeccion();
	}
	/*
	
	public ResultSet ejecutaConsultas() {
		
		producto miProducto;
		
		Connection accesoBBDD=miconexion.dameConexion();
		
		try {
			
			Statement secciones=accesoBBDD.createStatement();
			Statement paises=accesoBBDD.createStatement();
			 rs=secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
			 rs2=paises.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");
			
			 
			 miProducto=new producto();
			 miProducto.setSeccion(rs.getString(1));
			 miProducto.setpOrigen(rs2.getString(1));
			 
			 rs.close();
			 rs2.close();

		}catch(Exception e) {
			return null;
	}*/
	public conexion miconexion;
	public ResultSet rs;
	public ResultSet rs2;
}









