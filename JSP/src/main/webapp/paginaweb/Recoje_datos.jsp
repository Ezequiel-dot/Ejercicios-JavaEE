<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Completado</title>
</head>
<body>

<%@ page import="java.sql.*" %>

<%

	String nombre=request.getParameter("nombre");
	String apellido=request.getParameter("apellido");
	String usuario=request.getParameter("usuario");
	String contrase�a=request.getParameter("contra");
	String pais=request.getParameter("pais");
	String tecnologias=request.getParameter("tecnologias");
	

	Class.forName("com.mysql.jdbc.Driver");
	
	try{
	
	Connection miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");     
	Statement mistatement=miconexion.createStatement();

	String instruccionsql="INSERT INTO usuarios(Nombre, Apellido, Usuario, Contrase�a, Pais, Tecnologia) VALUES ('"+nombre+"','"+apellido+"','"+usuario+"','"+contrase�a+"','"+pais+"','"+tecnologias+"')";                      
	
	//String instruccionsql="INSERT INTO usuarios(Nombre, Apellido, Usuario, Contrase�a, Pa�s) VALUES ('"+nombre+"','"+apellido+"','"+usuario+"','"+contrase�a+"','"+pais+"')";                      

	mistatement.executeUpdate(instruccionsql);

	out.println("REGISTRADO EXITOSAMENTE");
	
	}catch (SQLException e) {
		out.println("HA OCURRIDO UN ERROR");

	}  

%>
</body>
</html>





