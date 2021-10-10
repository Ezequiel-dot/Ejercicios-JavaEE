package es.ezeosella.pruevaservlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/primerservlet")
public class primerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public primerservlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		PrintWriter salida=response.getWriter();
		
		salida.println("<html><body>");
		
		salida.println("<h1 style='text-align:center'>PRUEVA SERVLET</h1>");
		
		salida.println("Fecha y hora actual: ");
		
	//	salida.println(new Date());
		
		salida.println("</body></html>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
