package delegado;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import dto.ArticuloDTO;
import dto.ClienteDTO;
import dto.VendedorDTO;
import dto.VentaDTO;
import exception.ComunicationException;
import interfaces.RemoteInterface;



public class BusinessDelegate {
	
	private static BusinessDelegate instancia;
	private RemoteInterface ir;
	
	public static BusinessDelegate getInstancia() {
		if (instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}

	private BusinessDelegate() {
		
		try {
			ir = (RemoteInterface) Naming.lookup ("//localhost/ObjetoRemoto");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
		
	// Ambos
	public VendedorDTO loginUsuario(String email,String password) throws RemoteException, ComunicationException{
		return ir.loginUsuario(email, password);
	}
	
	public List<ArticuloDTO> listarArticulos() throws RemoteException, ComunicationException{
		return ir.listarArticulos();
	}
	
	public ClienteDTO buscarClienteByDni(String dni) throws RemoteException, ComunicationException {
		return ir.buscarClienteByDni(dni);
	}
	
	public void altaCliente(ClienteDTO cliente) throws RemoteException{
		ir.altaCliente(cliente);
	}
	
	public String crearboton(List<ArticuloDTO> articulos) throws RemoteException{
		return ir.crearboton(articulos);
	}
	
	public String enviarADeposito(List<ArticuloDTO> articulos) throws RemoteException{
		return ir.enviarADeposito(articulos);
	}
	
	public int procesarVenta(VentaDTO venta) throws RemoteException{
		return ir.procesarVenta(venta);
	}
	
	public VentaDTO buscarVenta(int idVenta) throws RemoteException{
		return ir.buscarVenta(idVenta);
	}

	
}