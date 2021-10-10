package app_final;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class aplicacion_universal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		marco mar=new marco();
		mar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mar.setVisible(true);
	}
}


class marco extends JFrame{
	public marco() {
		setBounds(200,200,500,300);
		setTitle("Aplicacion Final");
		add(new lamina());
	}
}

class lamina extends JPanel{
	public lamina() {
		
		setLayout(new BorderLayout());
		
		comboTablas=new JComboBox();
		
		conectarBBDD();
		obtenerTablas();
		
		comboTablas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				areaInformacion.setText(" ");
				String tablaSeleccionada=(String) comboTablas.getSelectedItem();
				mostrarInfoTabla(tablaSeleccionada);
			}
		});
		
		add(comboTablas,BorderLayout.NORTH);
		
		areaInformacion=new JTextArea();
		JScrollPane areaInformacion2=new JScrollPane(areaInformacion);
		add(areaInformacion2,BorderLayout.CENTER);
		
	
		
	}
	public void conectarBBDD() {
		miconexion=null;
		String datos[]=new String[3];
		
		try {	
			      
			entrada=new FileReader("C:/Users/ezeos/OneDrive/Escritorio/JAVA2/datos_configuracion.txt");
			
		} catch(IOException e) {
			
				JOptionPane.showMessageDialog(this, "No se encontro el archivo");
			
			    JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "Archivo de conecion", "txt");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(this);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getAbsolutePath());
			       
			       try {
					entrada=new FileReader (chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    }
			    
			    
		}
		
		BufferedReader mibuff=new BufferedReader(entrada);
		try {
		for(int i=0;i<3;i++) {
			datos[i]=mibuff.readLine();
		}
		
		//miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
		miconexion=DriverManager.getConnection(datos[0], datos[1], datos[2]);

		entrada.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void obtenerTablas() {
		ResultSet rs=null;
		
		try {
			
			DatabaseMetaData datosBBDD=miconexion.getMetaData();
			rs=datosBBDD.getTables(null, null, null, null);
			
			while(rs.next()) {
				comboTablas.addItem(rs.getString("TABLE_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void mostrarInfoTabla(String tabla) {
		
		ArrayList <String> campos=new ArrayList<String>();
		
		String consulta="SELECT * FROM "+tabla;
		
		Statement sentencia;
		try {
			sentencia = miconexion.createStatement();
			ResultSet rs=sentencia.executeQuery(consulta);
			
			ResultSetMetaData rsBBDD=rs.getMetaData();
			
			for(int i=1;i<rsBBDD.getColumnCount();i++) {
				
				campos.add(rsBBDD.getColumnLabel(i));
			}
			
			while(rs.next()) {
				for (String s : campos) {
					areaInformacion.append(rs.getString(s)+"--");
				}
				areaInformacion.append("\n");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private String con;
	private JComboBox comboTablas;
	private JTextArea areaInformacion;
	private Connection miconexion;
	private FileReader entrada;
}







