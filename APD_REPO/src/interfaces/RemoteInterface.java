package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.VendedorDTO;
import exception.ComunicationException;

public interface RemoteInterface extends Remote{
	public VendedorDTO loginUsuario(String email,String password) throws RemoteException, ComunicationException;
	
}
