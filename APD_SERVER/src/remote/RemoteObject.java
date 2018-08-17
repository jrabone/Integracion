package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import javax.naming.CommunicationException;

import controller.Controller;
import interfaces.RemoteInterface;

public class RemoteObject extends UnicastRemoteObject implements RemoteInterface{
	
	private static final long serialVersionUID = -421644367989846198L;	

	public RemoteObject() throws RemoteException,  RemoteException {}
}
