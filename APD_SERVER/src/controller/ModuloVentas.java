package controller;

import java.sql.SQLException;
import java.util.List;

import com.mercadopago.MP;

import dao.ArticuloDAO;
import dao.ClienteDAO;
import dao.VendedorDAO;
import dao.VentaDAO;
import dto.ArticuloDTO;
import dto.ChequeDTO;
import dto.ClienteDTO;
import dto.EfectivoDTO;
import dto.ItemVentaDTO;
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
	
	public String crearboton(List<ArticuloDTO> articulos) {
		MP mp = new MP("6103576789455888", "J3MAUDGrW9MB5FLIS20Xos44uQycaO7f");

		String preferenceData = "{'items':"+
			"[{"+
				"'title':'Multicolor kite',"+
				"'quantity':1,"+
				"'currency_id':'ARS',"+ // Available currencies at: https://api.mercadopago.com/currencies
				"'unit_price':10.0,"+
				"'auto_return':'all'," +
				"'back_urls': {" +
					"'success':'http://localhost:8002/APD_CTE_WEB/sucess.jsp'" +
				"}" +
			"}]"+
		"}";
		String initPoint = "";
		org.codehaus.jettison.json.JSONObject preference;
		try {
			preference = mp.createPreference(preferenceData);
			initPoint = preference.getJSONObject("response").getString("init_point");
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
