package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ARTICULO")
public class ArticuloEntity {
	@Id
	@Column(name = "idArticulo")
	private String idArticulo;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "precioUnitario")
	private double precioUnitario;
	@Column(name = "foto")
	private String foto;
	@Column(name = "stock")
	private int stock;
	
	public ArticuloEntity() {
	}
	
	public ArticuloEntity(String descripcion, double precioUnitario, String foto) {
		super();
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
		this.foto = foto;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
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
