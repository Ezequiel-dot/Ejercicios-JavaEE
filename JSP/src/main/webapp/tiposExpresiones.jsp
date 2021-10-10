<html>
<body style="margin:20px">
<h1 style="text-align:center">Tipos de Expresiones</h1>

<h2> expresiones </h2>
<br><br>
Convirtiendo a mayusculas: <%= new String("ezequiel").toUpperCase() %>

<br>

La suma de 5 + 7 es: <%= 5+7 %>

<br>

10 es mayor que 100: <%= 10>100 %>
<br><br>
<h2> Scriplets </h2>

<%

	for(int i=0;i<10;i++){
		out.print("<br>Este es el mensaje N°: "+i);
	}

%>
<br><br>

<h2> Declaraiones </h2>

<%!
public int metodoSuma(int a,int b){
	
	resultado=a+b;
	
	return resultado;
}
public int metodoResta(int a,int b){
	
	resultado=a-b;
	
	return resultado;
}
public int metodoMultiplica(int a,int b){
	
	resultado=a*b;
	
	return resultado;
}

private int resultado;


%>

El resultado de la suma es <%= metodoSuma(8,9) %>
<br>
El resultado de la resta es <%= metodoResta(8,9) %>
<br>
El resultado de la multiplicacion es <%= metodoMultiplica(8,9) %>

</body>
</html>














