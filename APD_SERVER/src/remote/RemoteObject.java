package remote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import controller.ModuloVentas;
import dto.ArticuloDTO;
import dto.ClienteDTO;
import dto.VendedorDTO;
import dto.VentaDTO;
import exception.ComunicationException;
import interfaces.RemoteInterface;

public class RemoteObject extends UnicastRemoteObject implements RemoteInterface{
	
	private static RemoteObject instancia;
	private static final long serialVersionUID = 1L;

	private RemoteObject() throws RemoteException {
		super();
	}

	public static RemoteObject getInstance() {
		if (instancia == null)
		{
			try {
				instancia = new RemoteObject();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	return instancia;
	}

	public VendedorDTO loginUsuario(String email, String password) throws RemoteException, ComunicationException {
		return ModuloVentas.getInstance().login(email, password);
	}
	
	public List<ArticuloDTO> listarArticulos() throws RemoteException, ComunicationException{
		List<ArticuloDTO> articulos = new ArrayList<ArticuloDTO>();
		String urlString = "http://6bf7c09a.ngrok.io/productos";	
		StringBuilder result = new StringBuilder();
	    URL url;
		try {
			url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		      conn.setRequestMethod("GET");
		      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		      String line;
		      while ((line = rd.readLine()) != null) {
		         result.append(line);
		      }
		      rd.close();
		      System.out.println(result);
		      
		      //JSONObject obj = new JSONObject(result.toString());

		      JSONArray items = new JSONArray(result.toString());
		      //JSONArray items = obj.getJSONArray("items");

		      for (int i = 0; i < items.length(); i++)
		      {
		    	  ArticuloDTO art = new ArticuloDTO();
		    	  art.setDescripcion(items.getJSONObject(i).getString("descripcion"));
		    	  art.setFoto(items.getJSONObject(i).getString("fotoUrl"));
		    	  art.setIdArticulo(items.getJSONObject(i).getInt("idProducto"));
		    	  art.setPrecioUnitario(items.getJSONObject(i).getDouble("precioVenta"));
		    	  art.setStock(items.getJSONObject(i).getInt("stockActual"));
		    	  art.setCodigoBarras(items.getJSONObject(i).getString("codigoBarras"));
		          articulos.add(art);
		      }
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		return articulos;
		//return ModuloVentas.getInstance().listarArticulos();
	}
	
	public ClienteDTO buscarClienteByDni(String dni) throws RemoteException, ComunicationException {
		return ModuloVentas.getInstance().buscarClienteByDNI(dni);
	}
	
	
	public void altaCliente(ClienteDTO cliente) throws RemoteException{
		ModuloVentas.getInstance().altaCliente(cliente);
	}
	
	public int procesarVenta(VentaDTO venta) throws RemoteException{
		return ModuloVentas.getInstance().procesarVenta(venta);
	}
	
	public VentaDTO buscarVenta(int idVenta) throws RemoteException{
		return ModuloVentas.getInstance().buscarVenta(idVenta);
	}

	public String crearboton(List<ArticuloDTO> articulos) throws RemoteException {
		return ModuloVentas.getInstance().crearboton(articulos);
	}
	
	public String enviarADeposito(List<ArticuloDTO> articulos) throws RemoteException {
		return ModuloVentas.getInstance().enviarADeposito(articulos);
	}
}
