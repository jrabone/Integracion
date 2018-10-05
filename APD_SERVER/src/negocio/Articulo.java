package negocio;

import java.sql.Blob;

import dao.ArticuloDAO;

public class Articulo {
	private Integer idArticulo;
	private String descripcion;
	private double precioUnitario;
	private String foto;


	private int stock;
	
	public Articulo(Integer idArticulo, String descripcion, double precioUnitario, String foto, int stock) {
		this.idArticulo = idArticulo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.foto = foto;
		this.stock = stock;
	}
	
	public Integer guardar() {
		this.idArticulo = ArticuloDAO.getInstancia().grabar(this);
		return this.idArticulo;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
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
	
	
}
