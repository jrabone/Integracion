package controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public class Controller {

	private static Controller controller;
	
	
	public Controller(){

	}
	
	public static Controller getInstance() {
		if(controller==null) {
			controller= new Controller();
		}
		return controller;
	}
}
