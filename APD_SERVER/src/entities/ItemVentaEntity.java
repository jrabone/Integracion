package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEMVENTA")
public class ItemVentaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="idItem")
	private Integer idItem;

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idArticulo", nullable=false)
	private ArticuloEntity articulo;
	
	@Column(name = "cantidad")
	private double cantidad;
	
	public ItemVentaEntity() {}
	
	public Integer getIdItem() {
		return idItem;
	}
	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public ArticuloEntity getArticulo() {
		return articulo;
	}
	public void setArticulo(ArticuloEntity articulo) {
		this.articulo = articulo;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
