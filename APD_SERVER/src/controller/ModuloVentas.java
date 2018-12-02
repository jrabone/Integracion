package controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import com.mercadopago.MP;

import dao.ArticuloDAO;
import dao.ClienteDAO;
import dao.VendedorDAO;
import dao.VentaDAO;
import dto.ArticuloDTO;
import dto.ArticuloIntegracionDTO;
import dto.ChequeDTO;
import dto.ClienteDTO;
import dto.ClienteIntegracionDTO;
import dto.DomicilioIntegracionDTO;
import dto.EfectivoDTO;
import dto.ItemPedidoDTO;
import dto.ItemVentaDTO;
import dto.PedidoDTO;
import dto.TarjetaCreditoDTO;
import dto.VendedorDTO;
import dto.VentaDTO;
import exception.ComunicationException;
import negocio.Articulo;
import negocio.Cheque;
import negocio.Cliente;
import negocio.Domicilio;
import negocio.Efectivo;
import negocio.TarjetaCredito;
import negocio.Venta;

public class ModuloVentas {

	private static ModuloVentas controller;
	
	
	public ModuloVentas(){

	}
	
	public static ModuloVentas getInstance() {
		if(controller==null) {
			controller= new ModuloVentas();
		}
		return controller;
	}
	
	public VendedorDTO login(String email, String password) throws ComunicationException{
		VendedorDTO vendedor = null;
		try {
			vendedor = VendedorDAO.getInstancia().loginUsuario(email, password);
		} catch (SQLException e) {
			new ComunicationException("Error en login de vendedor en BD, reintente");
		}	
		return vendedor;
	}
	
	public List<ArticuloDTO> listarArticulos() throws ComunicationException{
		List<ArticuloDTO> articulosDTO = null;
		try {
			articulosDTO = ArticuloDAO.getInstancia().buscarArticulos();
		}catch(SQLException e) {
			new ComunicationException("Error en listar articulos en BD, reintente");
		}
		return articulosDTO;
	}
	
	public String enviarADeposito(List<ArticuloDTO> articulos) {
		PedidoDTO test = new PedidoDTO();
		
		test.setNombreAlmacen(null);
		test.setFecha(null);
		test.setEstadoPedido(null);
		test.setRequiereLogistica(true);//Aclarar si requiere logistica
		List<ItemPedidoDTO> items = new ArrayList<ItemPedidoDTO>();
		for(ArticuloDTO articulo : articulos) {
			ItemPedidoDTO itemP = new ItemPedidoDTO();
			itemP.setCantidad(1);
			ArticuloIntegracionDTO art = new ArticuloIntegracionDTO();
			art.setCodigoBarras(articulo.getCodigoBarras());
			art.setDescripcion(articulo.getDescripcion());
			art.setFotoUrl(articulo.getFoto());
			art.setFragil(true);
			art.setIdProducto(articulo.getIdArticulo());
			art.setPrecioVenta(BigDecimal.valueOf(articulo.getPrecioUnitario()));
			art.setStockActual(articulo.getStock());
			itemP.setProducto(art);
			items.add(itemP);
		}
		test.setItems(items);
		
		//Cargo un ejemplo test de cliente
		ClienteIntegracionDTO testc = new ClienteIntegracionDTO();
		testc.setIdClienteTienda(null);  //inicializalo con null, igual no se va a tomar en cuenta si hay un nro
		testc.setCuil_cuit_dni("12.345.678");
		testc.setNombreYApellido_RazonSocial("Pepe Argento");
		testc.setEmail("pepeargento@gmail.com");
		test.setCliente(testc);
		
		DomicilioIntegracionDTO testd = new DomicilioIntegracionDTO();
		testd.setIdDireccionCliente(null);
		testd.setCalle("Lima");
		testd.setNumero("717");
		testd.setPiso("8");
		testd.setUnidad("A");
		testd.setEntreCalles("Av Independencia y Calle Chile");
		testd.setProvincia("Bs As");
		testd.setLocalidad("Montserrat");
		testd.setCodigoPostal("1073");
		test.setDireccion(testd);
		
		test.setFragil(false);  //No es necesario cargar esto, ya que el almacen
		//va a deducir que, con que 1 producto sea fragil, todo el pedido sera fragil.	
		
		try {			
			JSONObject jsonDto = new JSONObject(test);
			
			
			//Esto es para corroborar cómo será mandado
			System.out.println(jsonDto.toString());

			String IP = "http://6bf7c09a.ngrok.io";
			
			StringEntity entity;
				entity = new StringEntity(jsonDto.toString(), "UTF-8");
				HttpClient httpClient = HttpClientBuilder.create().build();
				HttpPost request = new HttpPost(IP+"/pedido");
				request.setHeader("Accept", "application/json");
				request.setHeader("Content-type", "application/json");
				request.setEntity(entity);

				HttpResponse response = httpClient.execute(request);
				System.out.println(response.getStatusLine().getStatusCode());
				return Integer.toString(response.getStatusLine().getStatusCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Algo Salio Mal";	
	}
	
	public String crearboton(List<ArticuloDTO> articulos) {
		MP mp = new MP("6103576789455888", "J3MAUDGrW9MB5FLIS20Xos44uQycaO7f");

		String lista = "";

		int i = 0;
		
		for(ArticuloDTO articulo : articulos) {
			if(i++ == articulos.size() -1) {
				String item = "{"+
						"'title':'" + articulo.getDescripcion() + "',"+
						"'quantity':1,"+
						"'currency_id':'ARS',"+ 
						"'unit_price':" + Double.toString(articulo.getPrecioUnitario()) + ","+
						"'auto_return':'all'" + 
					"}";
					lista = lista + item;
			}
			else {
				String item = "{"+
						"'title':'" + articulo.getDescripcion() + "',"+
						"'quantity':1,"+
						"'currency_id':'ARS',"+ 
						"'unit_price':" + Double.toString(articulo.getPrecioUnitario()) + ","+
						"'auto_return':'all'" + 
					"},";
					lista = lista + item;
			}
		}
		
		
		
		String preferenceData = "{'items':"+
			"[" + lista + "],"+
			"'back_urls': {" +
				"'success':'http://localhost:8002/APD_CTE_WEB/sucess.jsp'" +
			"}" +
		"}";
		String initPoint = "";
		org.codehaus.jettison.json.JSONObject preference;
		try {
			preference = mp.createPreference(preferenceData);
			initPoint = preference.getJSONObject("response").getString("sandbox_init_point");
			System.out.println(initPoint);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return initPoint;		
	}
	
	public void agregarArticulo(Articulo a) {
		ArticuloDAO.getInstancia().grabar(a);
	}
	
	public ClienteDTO buscarClienteByDNI(String dni) throws ComunicationException {
		ClienteDTO cliente = null;
		cliente = ClienteDAO.getInstancia().buscarClienteById(dni);
		return cliente;
	}
	
	public void altaCliente(ClienteDTO cliente) {
		Domicilio domicilioEntrega = new Domicilio(cliente.getDomicilioDeEntrega().getIdDomicilio(), cliente.getDomicilioDeEntrega().getPais(), 
				cliente.getDomicilioDeEntrega().getProvincia(), cliente.getDomicilioDeEntrega().getLocalidad(), cliente.getDomicilioDeEntrega().getCodigoPostal(),
				cliente.getDomicilioDeEntrega().getCalle(), cliente.getDomicilioDeEntrega().getNumero(), cliente.getDomicilioDeEntrega().getPiso(),
				cliente.getDomicilioDeEntrega().getDpto());
		Domicilio domicilioFacturacion = new Domicilio(cliente.getDomicilioDeFacturacion().getIdDomicilio(), cliente.getDomicilioDeFacturacion().getPais(), 
				cliente.getDomicilioDeFacturacion().getProvincia(), cliente.getDomicilioDeFacturacion().getLocalidad(), cliente.getDomicilioDeFacturacion().getCodigoPostal(),
				cliente.getDomicilioDeFacturacion().getCalle(), cliente.getDomicilioDeFacturacion().getNumero(), cliente.getDomicilioDeFacturacion().getPiso(),
				cliente.getDomicilioDeFacturacion().getDpto());
		Cliente clienteNegocio = new Cliente(cliente.getIdCliente(), cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getCelular(),
				domicilioEntrega, domicilioFacturacion, null);
		clienteNegocio.save();
	}
	
	public int procesarVenta(VentaDTO ventaNueva) {
		Integer numeroPedido = 0;
		if (ventaNueva instanceof ChequeDTO) {
			ChequeDTO venta = ((ChequeDTO) ventaNueva);
			Cheque cheque = new Cheque(venta.getIdVenta(), venta.getFecha(), "Confirmada", venta.getObservaciones(), venta.getEntregaInmediata(), ClienteDAO.getInstancia().toNegocio(venta.getCliente()), null, venta.getNumeroCheque(), venta.getBanco(), venta.getTitular(), venta.getVencimiento());
			numeroPedido = cheque.save();
			for(ItemVentaDTO item : venta.getItems()) {
				Articulo articulo = ArticuloDAO.getInstancia().toNegocio(item.getArticulo());
				cheque.agregarItem(articulo, item.getCantidad());
			}
			// informar venta a almacen
			
		}else {
			if (ventaNueva instanceof EfectivoDTO) {
				EfectivoDTO venta = ((EfectivoDTO) ventaNueva);
				Efectivo efectivo = new Efectivo(venta.getIdVenta(), venta.getFecha(), "Confirmada", venta.getObservaciones(), venta.getEntregaInmediata(), ClienteDAO.getInstancia().toNegocio(venta.getCliente()), null);
				numeroPedido = efectivo.save();
				for(ItemVentaDTO item : venta.getItems()) {
					Articulo articulo = ArticuloDAO.getInstancia().toNegocio(item.getArticulo());
					efectivo.agregarItem(articulo, item.getCantidad());
				}
				// informar venta a almacen
				
			}else {
				if (ventaNueva instanceof TarjetaCreditoDTO) {
					TarjetaCreditoDTO venta = ((TarjetaCreditoDTO) ventaNueva);
					TarjetaCredito tarjeta = new TarjetaCredito(venta.getIdVenta(), venta.getFecha(), "Pendiente", venta.getObservaciones(), venta.getEntregaInmediata(), ClienteDAO.getInstancia().toNegocio(venta.getCliente()), null, venta.getCodigoConfirmacionMP());
					numeroPedido = tarjeta.save();
					for(ItemVentaDTO item : venta.getItems()) {
						Articulo articulo = ArticuloDAO.getInstancia().toNegocio(item.getArticulo());
						tarjeta.agregarItem(articulo, item.getCantidad());
					}
					// Confirmación de MP
					tarjeta.setIdVenta(numeroPedido);
					tarjeta.actualizarEstado("Confirmada", "CodigoPruebaMP");
					// Informar venta a almacen
				}
				}
			}
		return numeroPedido;
	}
	
	public VentaDTO buscarVenta(int idVenta) {
		return VentaDAO.getInstancia().buscarVenta(idVenta);
	}
	
	public void informarVentaAlmacen(Venta venta) {
		
	}

	
}
