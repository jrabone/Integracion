package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.VendedorDTO;
import exception.ComunicationException;

public interface RemoteInterface extends Remote{
	public static final String url = "//localhost/ObjetoRemoto";
	
	public VendedorDTO loginUsuario(String email,String password) throws RemoteException, ComunicationException;
	
}
