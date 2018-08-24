package negocio;

public class Articulo {
	private String idArticulo;
	private String descripcion;
	private double precioUnitario;
	
	public Articulo(String idArticulo, String descripcion, double precioUnitario) {
		this.idArticulo = idArticulo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
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
	
	
}
