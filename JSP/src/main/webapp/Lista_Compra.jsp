
<%@ page import="java.util.*" %>
<html>

<body>
<form name="Formulario_Compra" action="Lista_Compra.jsp">
 
  <p>Artículos a comprar:</p>
  <p>
    <label>
      <input type="checkbox" name="articulos" value="agua " >
      Agua </label>
    <br>
    <label>
      <input type="checkbox" name="articulos" value="leche" >
      Leche </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="pan" >
      Pan </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="mazanas" >
      Manzanas </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="carne" >
      Carne </label>
      <br>
       <label>
      <input type="checkbox" name="articulos" value="pescado" >
      Pescado </label>
  </p>
  <p>
    <input type="submit" name="button" id="button" value="Enviar">
    <br>
  </p>
</form>
<h2>Carrito de compras</h2>
<ul>

<%

List<String> listaElementos=(List<String>) session.getAttribute("misElementos");

if(listaElementos == null){
	 listaElementos=new ArrayList<String>();
	session.setAttribute("misElementos",listaElementos);
}



String [] elementos=request.getParameterValues("articulos");

if(elementos!= null){
	for(String e :elementos){
		
		//out.println("<li>"+e+"</li>");
		
		listaElementos.add(e);
		
	}
}

for(String e:listaElementos){
	
	out.println("<li>"+e+"</li>");

}

%>
</ul>
</body>

</html>