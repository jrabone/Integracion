package server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.naming.CommunicationException;

import controller.ModuloVentas;

public class StartUp {

	Random r;
	ModuloVentas c;
	
	public StartUp(){
		r= new Random();
		c= ModuloVentas.getInstance();
	}
}
