package controller;

import java.sql.SQLException;
import java.util.List;

import dao.ArticuloDAO;
import dao.VendedorDAO;
import dto.ArticuloDTO;
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
	
	public List<ArticuloDTO> listarArticulos() throws ComunicationException{
		List<ArticuloDTO> articulosDTO = null;
		try {
			articulosDTO = ArticuloDAO.getInstancia().buscarArticulos();
		}catch(SQLException e) {
			new ComunicationException("Error en listar articulos en BD, reintente");
		}
		return articulosDTO;
	}
	
	

	
	// Listar articulos
	
	// Confirmar carrito (Paga en efectivo, paga en TC, paga cheque)
	// Mandarle la venta a almacen (Primero deberia haber un metodo de ellos
	// que nos diga si todo lo que esta en el carrito tiene stock OK y que no hay mas stock
	// y si esta OK, mandarle la venta completa)
	// Cambiar estado de venta a FINALIZADA
	
	// Registrar cliente
	
	// Buscar cliente
	// Del cliente traer SI sus compras.
	
	
}
