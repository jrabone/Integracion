package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.ArticuloDTO;
import dto.ClienteDTO;
import dto.VendedorDTO;
import dto.VentaDTO;
import exception.ComunicationException;

public interface RemoteInterface extends Remote{
	public static final String url = "//localhost/ObjetoRemoto";
	
	public VendedorDTO loginUsuario(String email,String password) throws RemoteException, ComunicationException;
	
	public List<ArticuloDTO> listarArticulos() throws RemoteException, ComunicationException;
	
	public ClienteDTO buscarClienteByDni(String dni) throws RemoteException, ComunicationException;
	
	public void altaCliente(ClienteDTO cliente) throws RemoteException;
	
	public int procesarVenta(VentaDTO venta) throws RemoteException;
	
	public VentaDTO buscarVenta(int idVenta) throws RemoteException;
	
	public String crearboton(List<ArticuloDTO> articulos) throws RemoteException;
}
