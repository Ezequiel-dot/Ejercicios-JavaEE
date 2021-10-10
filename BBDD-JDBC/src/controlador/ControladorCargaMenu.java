package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import vista.*;
import modelo.*;

public class ControladorCargaMenu extends WindowAdapter{
	
	public ControladorCargaMenu(marco marc) {
		this.marc=marc;
	}

	public void windowOpened(WindowEvent e) {
		
		cs.ejecutaConsultas();
		
		try {
			while(cs.rs.next()) {
				marc.secciones.addItem(cs.rs.getString(1));
			}
			while(cs.rs2.next()) {
				marc.paises.addItem(cs.rs2.getString(1));
			}
		}catch(Exception ee) {
			
		}
		
	}
	
	CargarMenus cs=new CargarMenus();
	private marco marc;
}




