<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	//leer datos formulario
	
	String ciudades=request.getParameter("ciudades");
	
	//craer kooki
	
	Cookie lacoki=new Cookie("agencia_viaje.ciudad_favorita",ciudades);
	
	//vida util de la cooki
	
	lacoki.setMaxAge(60*60*24*365);
	
	//enviar cooki al usuario
	
	response.addCookie(lacoki);
%>

Gracias por eviar sus preferencias!!

<br><br>

<a href="agencia_viajes.jsp">Ir a la agencia de viajes</a>

</body>
</html>