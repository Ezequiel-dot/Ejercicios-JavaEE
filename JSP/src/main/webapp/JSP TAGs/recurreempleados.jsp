<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="java.util.* , java.sql.* , jsptags.com.aprendiendo.empleado" %>
    
    <%
    
    Arraylist <empleado> datos=new Arraylist<>();
    
    class.forName("com.mysql.jdbc.Driver");
    
    try{
    	
    	Connection micone=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp","root","");
    	Statement mistate=micone.createStatement();
    	
    	String instruccionsql="SELECT * FROM EMPLEADOS";
    	
    	ResultSet rs=mistate.executeQuery(instruccionsql);
    	
    	while(rs.next()){
    		datos.add(new empleado(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4)));
    	}
    	
    	rs.close();
    	micone.close();
    	
    	
    	pageContext.setAttribute("losEmpleados",datos);
    	
    }catch(Exception e){
    	out.println("error");
    }
    
    
    %>
    
<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:forEach var="EmpTemp" items="${losEmpleados }">

${EmpTemp.nombre}  ${EmpTemp.apellido}  ${EmpTemp.puesto} 

<c:if test="${EmpTemp.salario<40000 }">

${EmpTemp.salario+5000 }

</c:if>

<c:if test="${EmpTemp.salario>=40000 }">

${EmpTemp.salario }

</c:if>
</br>

</c:forEach>

</body>
</html>




