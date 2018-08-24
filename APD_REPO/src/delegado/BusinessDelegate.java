package delegado;

import java.rmi.Naming;
import java.rmi.RemoteException;

import dto.VendedorDTO;
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

	
}