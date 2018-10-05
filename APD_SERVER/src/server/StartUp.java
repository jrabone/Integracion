package server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.naming.CommunicationException;

import controller.ModuloVentas;
import negocio.Articulo;

public class StartUp {

	Random r;
	ModuloVentas c;
	
	public StartUp(){
		r= new Random();
		c= ModuloVentas.getInstance();
		
		System.out.println("Alta de Articulos.");	
		altaArticulos();		
		System.out.println("PERSISTIDOS OK");
	}
	
	public void altaArticulos() {
		ArrayList<Articulo> articulos = new ArrayList<>();
		
		articulos.add(new Articulo(0, "Mochila 1", 120, "https://samsonitear.vteximg.com.br/arquivos/ids/155701-1000-1000/106235-1599-1.jpg?v=636529131812770000", 20));
		articulos.add(new Articulo(0, "Mochila 2", 220, "https://samsonitear.vteximg.com.br/arquivos/ids/156632-1000-1000/7501068868487_1.jpg?v=636603642508300000", 0));
		articulos.add(new Articulo(0, "Mochila 3", 320, "https://samsonitear.vteximg.com.br/arquivos/ids/158183-1000-1000/7501068861914_1.jpg?v=636680402469270000", 120));
		articulos.add(new Articulo(0, "Mochila 4", 420, "https://samsonitear.vteximg.com.br/arquivos/ids/158512-1000-1000/5414847810053_1.jpg?v=636693358544000000", 250));
		articulos.add(new Articulo(0, "Mochila 5", 520, "https://samsonitear.vteximg.com.br/arquivos/ids/158091-1000-1000/43202723889_1.jpg?v=636674232075500000", 4));
		
		for(Articulo art: articulos) {
			art.guardar();
		}
	}
}
