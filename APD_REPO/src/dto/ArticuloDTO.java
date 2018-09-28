package dto;

import java.io.Serializable;

public class ArticuloDTO implements Serializable {
	private String idArticulo;
	private String descripcion;
	private double precioUnitario;
	private String foto;
	private int stock;
	
	public ArticuloDTO() {}

	public String getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public ArticuloDTO(String idArticulo, String descripcion, double precioUnitario, String foto, int stock) {
		super();
		this.idArticulo = idArticulo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.foto = foto;
		this.stock = stock;
	}
}
