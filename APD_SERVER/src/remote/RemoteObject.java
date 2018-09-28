package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import controller.ModuloVentas;
import dto.ArticuloDTO;
import dto.VendedorDTO;
import exception.ComunicationException;
import interfaces.RemoteInterface;

public class RemoteObject extends UnicastRemoteObject implements RemoteInterface{
	
	private static RemoteObject instancia;
	private static final long serialVersionUID = 1L;

	private RemoteObject() throws RemoteException {
		super();
	}

	public static RemoteObject getInstance() {
		if (instancia == null)
		{
			try {
				instancia = new RemoteObject();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	return instancia;
	}

	public VendedorDTO loginUsuario(String email, String password) throws RemoteException, ComunicationException {
		return ModuloVentas.getInstance().login(email, password);
	}
	
	public List<ArticuloDTO> listarArticulos() throws RemoteException, ComunicationException{
		return ModuloVentas.getInstance().listarArticulos();
	}
}
