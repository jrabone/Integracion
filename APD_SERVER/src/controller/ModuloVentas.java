package controller;

import java.sql.SQLException;

import dao.VendedorDAO;
import dto.VendedorDTO;
import exception.ComunicationException;

public class ModuloVentas {

	private static ModuloVentas controller;
	
	
	public ModuloVentas(){

	}
	
	public static ModuloVentas getInstance() {
		if(controller==null) {
			controller= new ModuloVentas();
		}
		return controller;
	}
	
	public VendedorDTO login(String email, String password) throws ComunicationException{
		VendedorDTO vendedor = null;
		try {
			vendedor = VendedorDAO.getInstancia().loginUsuario(email, password);
		} catch (SQLException e) {
			new ComunicationException("Error en login de vendedor en BD, reintente");
		}	
		return vendedor;
	}
}
