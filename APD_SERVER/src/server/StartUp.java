package server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.naming.CommunicationException;

import controller.Controller;

public class StartUp {

	Random r;
	Controller c;
	
	public StartUp(){
		r= new Random();
		c= Controller.getInstance();
	}
}
