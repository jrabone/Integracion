package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import negocio.Articulo;

@Entity
@Table(name="ARTICULO")
public class ArticuloEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idArticulo")
	private Integer idArticulo;
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
	
	public ArticuloEntity(Articulo articulo) {
		super();
		this.descripcion = articulo.getDescripcion();
		this.precioUnitario = articulo.getPrecioUnitario();
		this.stock = articulo.getStock();
		this.foto = articulo.getFoto();
	}
	
	public Articulo toNegocio() {
		return new Articulo(idArticulo, descripcion, precioUnitario, foto, stock);
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
