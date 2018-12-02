package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoDTO implements Serializable {
private static final long serialVersionUID = 2138990749512674129L;
	
	private Integer idPedido;		//Para enviar al almacen, null, luego el almacen le enviará una id
	private String nombreAlmacen;	//Nombre String que identifica el almacén de origen/destino.
	private Date fecha;				//null o "fecha = new Date()" para enviar
	private String estadoPedido;	//'vacio' para enviar, luego recibe estados de pedido
	private boolean requiereLogistica;
	
	private ClienteIntegracionDTO cliente;
	private DomicilioIntegracionDTO direccion;
	private boolean fragil;
	
	private List<ItemPedidoDTO> items;
	
	
	
	//Constructor
	public PedidoDTO() {
		this.items = new ArrayList<ItemPedidoDTO>();
	}
	
	
	//Constructor
	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	
	public String getNombreAlmacen() {
		return nombreAlmacen;
	}


	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public boolean isRequiereLogistica() {
		return requiereLogistica;
	}

	public void setRequiereLogistica(boolean requiereLogistica) {
		this.requiereLogistica = requiereLogistica;
	}

	public ClienteIntegracionDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIntegracionDTO cliente) {
		this.cliente = cliente;
	}

	public DomicilioIntegracionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(DomicilioIntegracionDTO direccion) {
		this.direccion = direccion;
	}

	public boolean isFragil() {
		return fragil;
	}

	public void setFragil(boolean fragil) {
		this.fragil = fragil;
	}

	public List<ItemPedidoDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemPedidoDTO> items) {
		this.items = items;
	}
}
