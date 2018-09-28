package dto;

import java.io.Serializable;

public class ItemVentaDTO implements Serializable {
	private ArticuloDTO articulo;
	private double cantidad;
	
	public ItemVentaDTO() {}

	public ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

}
