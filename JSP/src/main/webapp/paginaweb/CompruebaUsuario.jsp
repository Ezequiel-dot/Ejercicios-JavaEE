<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.sql.*" %>

<%

String usuario=request.getParameter("usuario");
String contraseña=request.getParameter("contra");

Class.forName("com.mysql.jdbc.Driver");

Connection miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");     
PreparedStatement consultaPredarada=miconexion.prepareStatement("SELECT * FROM USUARIOS WHERE USUARIO=? AND CONTRASEÑA=?");
consultaPredarada.setString(1,usuario);
consultaPredarada.setString(2,contraseña);

ResultSet rs=consultaPredarada.executeQuery();

if(rs.absolute(1))out.println("Usuario Correcto");
else   out.println("No hay usuarios con los datos ingresados");

%>

</body>
</html>