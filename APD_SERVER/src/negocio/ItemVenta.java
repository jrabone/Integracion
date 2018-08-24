package negocio;

public class ItemVenta {
	private Articulo articulo;
	private double cantidad;
	
	public ItemVenta(Articulo articulo, double cantidad) {
		this.articulo = articulo;
		this.cantidad = cantidad;
	}
	
	public double getSubtotal() {
		return this.articulo.getPrecioUnitario() * this.cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
}
