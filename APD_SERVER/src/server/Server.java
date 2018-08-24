package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.hibernate.SessionFactory;

import hbt.HibernateUtil;
import interfaces.RemoteInterface;
import remote.RemoteObject;

public class Server extends Thread {
	RemoteInterface objetoRemoto;

	@SuppressWarnings("unused")
	private static SessionFactory sf = null;

	// Constructor del servidor
	public Server() {
		iniciar();
	}

	// Main del servidor
	public static void main(String[] args) {
		new Server();
	}
	
	public void iniciar() {
		try {
			LocateRegistry.createRegistry(1099);
			objetoRemoto = RemoteObject.getInstance();
			Naming.rebind(RemoteInterface.url, objetoRemoto);
			sf = HibernateUtil.getSessionFactory();
			System.out.println("Servidor inicializado correctamente...");

		
	 		

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

