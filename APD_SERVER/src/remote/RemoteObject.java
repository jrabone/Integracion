package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controller.ModuloVentas;
import dto.VendedorDTO;
import exception.ComunicationException;
import interfaces.RemoteInterface;

public class RemoteObject extends UnicastRemoteObject implements RemoteInterface{
	
	private static final long serialVersionUID = -421644367989846198L;	

	public RemoteObject() throws RemoteException,  RemoteException {}

	public VendedorDTO loginUsuario(String email, String password) throws RemoteException, ComunicationException {
		return ModuloVentas.getInstance().login(email, password);
	}
}
