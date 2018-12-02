package dto;

import java.io.Serializable;

public class ArticuloDTO implements Serializable {
	private Integer idArticulo;
	private String descripcion;
	private double precioUnitario;
	private String codigoBarras;
	private String foto;
	private int stock;
	
	public ArticuloDTO() {}

	public Integer getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Integer idArticulo) {
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

	public ArticuloDTO(Integer idArticulo, String descripcion, double precioUnitario, String foto, int stock, String codBarras) {
		super();
		this.idArticulo = idArticulo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.foto = foto;
		this.stock = stock;
		this.codigoBarras = codBarras;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
}
