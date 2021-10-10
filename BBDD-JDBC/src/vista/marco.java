package vista;

import java.awt.BorderLayout;

import javax.swing.*;

import controlador.ControladorCargaMenu;
import controlador.controladorBoton;


public class marco extends JFrame{
	public marco() {
		
		setBounds(200,200,500,300);
		setTitle("Aplicacion Consulta");
		

		setLayout(new BorderLayout());
		
		
		
	//	JPanel lamina=new JPanel();
		
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
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		botonConsulta.addActionListener(new controladorBoton(this));
		
		addWindowListener(new ControladorCargaMenu(this));
	}

	public JComboBox secciones;
	public JComboBox paises;
	public JTextArea resultado;
}






