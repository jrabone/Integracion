package negocio;

import java.sql.Blob;

public class Articulo {
	private String idArticulo;
	private String descripcion;
	private double precioUnitario;
	private String foto;
	
	public Articulo(String idArticulo, String descripcion, double precioUnitario, String foto) {
		this.idArticulo = idArticulo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.foto = foto;
	}
	
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
	
	
}
