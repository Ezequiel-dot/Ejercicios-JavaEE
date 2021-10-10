package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;
import vista.*;

public class controladorBoton implements ActionListener{
	
	public controladorBoton(marco mar){
		this.mar=mar;
	}
	

	public void actionPerformed(ActionEvent e) {
		
		String seleccionSeccion= (String) mar.secciones.getSelectedItem();
		String seleccionPaises=(String) mar.paises.getSelectedItem();
		
		resultadoCons=ec.filtrarBBDD(seleccionSeccion, seleccionPaises);
		
		mar.resultado.setText("");
		
		try {
			while(resultadoCons.next()) {
				mar.resultado.append(resultadoCons.getString(1));
				mar.resultado.append(",");
				mar.resultado.append(resultadoCons.getString(2));
				mar.resultado.append(",");
				mar.resultado.append(resultadoCons.getString(3));
				mar.resultado.append(",");
				mar.resultado.append(resultadoCons.getString(4));
				mar.resultado.append(",");
				mar.resultado.append("\n");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	private marco mar;
	private ejecutaConsultas ec=new ejecutaConsultas();
	private ResultSet resultadoCons;
	
}






