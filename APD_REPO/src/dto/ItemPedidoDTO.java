package dto;

import java.io.Serializable;
import java.util.Date;

public class ItemPedidoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4887972208710641334L;
	
	private Integer idPedidoItem;
	private ArticuloIntegracionDTO producto;
	private int cantidad;
	
	
	
	
	//Constructor
	public ItemPedidoDTO() {
		super();
	}
	
	
	
	//Getters y setters
	public Integer getIdPedidoItem() {
		return idPedidoItem;
	}


	public void setIdPedidoItem(Integer idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}
	

	public ArticuloIntegracionDTO getProducto() {
		return producto;
	}


	public void setProducto(ArticuloIntegracionDTO producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}
	
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
