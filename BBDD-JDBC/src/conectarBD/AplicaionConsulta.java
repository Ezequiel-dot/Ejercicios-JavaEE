package conectarBD;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AplicaionConsulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		marco m=new marco();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);

	}

}

class marco extends JFrame{
	public marco() {
		
		setBounds(200,200,500,300);
		setTitle("Aplicacion Consulta");
		
		add(new lamina());
	}
}

class lamina extends JPanel{
	public lamina() {
		
		setLayout(new BorderLayout());
		
		JPanel lamina2=new JPanel();
		
		secciones=new JComboBox();
		
		secciones.addItem("Todos");
		
		lamina2.add(secciones);
		
		paises=new JComboBox();
		
		paises.addItem("Todos");
		
		lamina2.add(paises);
		
		add(lamina2,BorderLayout.NORTH);
		
		resultado=new JTextArea();
		
		JScrollPane scroll=new JScrollPane(resultado);
		
		add(scroll,BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");
		
		botonConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultado.setText("");
				ejecutaConsulta();
			}
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
//--------------------BBDD---------------------------------------------------
		
		try {
			
		
		//-----------------CARGA PRODUCTOS EN COMBOBOX----------------------
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
		
			Statement sentencia=conexion.createStatement();
			
			String sql="SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";
			
			ResultSet rs=sentencia.executeQuery(sql);
			
			while(rs.next()) {
			//	System.out.println(rs.getString(1));
				
				secciones.addItem(rs.getString(1));
			}
			
			rs.close();
			
	//-----------------CARGA PAISES EN COMBOBOX----------------------

			
			sql="SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
			
			rs=sentencia.executeQuery(sql);
			
			while(rs.next()) {
			//	System.out.println(rs.getString(1));
				
				paises.addItem(rs.getString(1));
			}
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				
	}
	
	private void ejecutaConsulta() {
		ResultSet res=null;
		
		try {
			
			String seccion=(String) secciones.getSelectedItem();
			
			String pais=(String) paises.getSelectedItem();
			
			//solo elige seccion
			
			if(!seccion.equals("Todos") && pais.equals("Todos")){

			enviaConsultaProducto=conexion.prepareStatement(consulta);
			
			enviaConsultaProducto.setString(1,seccion);
			
			res=enviaConsultaProducto.executeQuery();
			//solo elige pais
			
			}else if(seccion.equals("Todos") && !pais.equals("Todos")) {
				enviaConsultaProducto2=conexion.prepareStatement(consulta2);
				
				enviaConsultaProducto2.setString(1,pais);
				
				res=enviaConsultaProducto2.executeQuery();
			}
			// elije ambas
			else if(!seccion.equals("Todos") && !pais.equals("Todos")) {
				enviaConsultaProducto3=conexion.prepareStatement(consulta3);
				
				enviaConsultaProducto3.setString(1,seccion);
				enviaConsultaProducto3.setString(2,pais);
				res=enviaConsultaProducto3.executeQuery();
			}else if(seccion.equals("Todos") && pais.equals("Todos")){
				enviaConsultaProducto4=conexion.prepareStatement(consulta4);
				
				
				res=enviaConsultaProducto4.executeQuery();
				//System.out.println("hola");
			}
			
			while(res.next()) {
				resultado.append(res.getString(1));
				resultado.append(", ");
				resultado.append(res.getString(2));
				resultado.append(", ");
				resultado.append(res.getString(3));
				resultado.append(", ");
				resultado.append(res.getString(4));
				resultado.append(", ");
				resultado.append("\n");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	 
	private JComboBox secciones;
	private JComboBox paises;
	private Connection conexion;
	private JTextArea resultado;
	
	private PreparedStatement enviaConsultaProducto;
	private final String consulta="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN "
			+ "FROM PRODUCTOS WHERE SECCIÓN=?"; 
	
	private PreparedStatement enviaConsultaProducto2;
	private final String consulta2="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN "
			+ "FROM PRODUCTOS WHERE PAÍSDEORIGEN=?"; 
	
	private PreparedStatement enviaConsultaProducto3;
	private final String consulta3="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN "
			+ "FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?"; 
	
	private PreparedStatement enviaConsultaProducto4;
	private final String consulta4="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN "
			+ "FROM PRODUCTOS"; 
}





