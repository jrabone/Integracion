package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.hibernate.SessionFactory;

import hbt.HibernateUtil;
import interfaces.RemoteInterface;
import remote.RemoteObject;

public class Server {

	private static SessionFactory sf = null;
	public static void main(String args[]) {
		try {
			new Server();
			
		    startUp();
			System.out.println("SERVER: ARRANCADO!");
		} catch (RemoteException e) {
			System.out.println("SERVER: ERROR! "+e.getMessage());
		}
	}
	
	public Server() throws RemoteException{
		inicializar();
	}
	
	public void inicializar() throws RemoteException{
		RemoteInterface ri = new RemoteObject();
		try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind("//localhost/DasVerruckteLagerhaus", ri);
			sf = HibernateUtil.getSessionFactory();			
		} catch (MalformedURLException e){
			e.printStackTrace();
		}
	}
	
	private static void startUp() {
		StartUp sup= new StartUp();
		//sup.altaUsuarios();
		//sup.altaClientes();
		//sup.altaUbicaciones();
		//sup.altaArticulos();
		//sup.altaProductos();
		//sup.altaProveedores();
		//sup.asociarProdProv();
	}
}
