package server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.naming.CommunicationException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.mercadopago.MP;

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
		//updateStock();
		//crearboton();
		System.out.println("MERCADO");
	}
	
	private void crearboton() {
		MP mp = new MP("6103576789455888", "J3MAUDGrW9MB5FLIS20Xos44uQycaO7f");

		String preferenceData = "{'items':"+
			"[{"+
				"'title':'Multicolor kite',"+
				"'quantity':1,"+
				"'currency_id':'ARS',"+ // Available currencies at: https://api.mercadopago.com/currencies
				"'unit_price':10.0"+
			"}]"+
		"}";

		JSONObject preference;
		try {
			preference = mp.createPreference(preferenceData);
			String initPoint = preference.getJSONObject("response").getString("sandbox_init_point");
			System.out.println(initPoint);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void updateStock() {
		String urlString = "http://localhost/TestWS/api/values";
		try {
			URL url = new URL(urlString);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("POST");
			httpCon.setRequestProperty("Content-Type", "application/json");
			OutputStream os = httpCon.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			JSONArray productos = new JSONArray();
		    JSONObject prod=new JSONObject();
		    prod.put("id","1");
		    prod.put("cantidad","1");
		    productos.put(prod);
			osw.write(productos.toString());
			osw.flush();
			osw.close();
			os.close();  //don't forget to close the OutputStream
			httpCon.connect();

			//read the inputstream and print it
			String result;
			BufferedInputStream bis = new BufferedInputStream(httpCon.getInputStream());
			ByteArrayOutputStream buf = new ByteArrayOutputStream();
			int result2 = bis.read();
			while(result2 != -1) {
			    buf.write((byte) result2);
			    result2 = bis.read();
			}
			result = buf.toString();
			System.out.println(result);		    
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		}

		
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
