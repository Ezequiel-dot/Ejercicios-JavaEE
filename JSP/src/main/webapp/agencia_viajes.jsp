<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<h1 style="text-align:center">Agencia de viajes</h1>
<body>

<%

	//valor por defecto
	
	String ciudad_favorita="Buenos Aires";

	//lee la cooki de la peticion del navegador
	
	Cookie[] lascokis=request.getCookies();
	
	
	//buscar las preferencias
	
	if(lascokis != null){
		for(Cookie c:lascokis){
			if("agencia_viaje.ciudad_favorita".equals(c.getName())){
				ciudad_favorita=c.getValue();
				break;
			}
		}
	}
	
	
%>

<h3>Vuelos ha <%= ciudad_favorita %></h3>

<p>texto ejmplo</p>
<p>texto ejmplo</p>
<p>texto ejmplo</p>
<p>texto ejmplo</p>

</body>
</html>







