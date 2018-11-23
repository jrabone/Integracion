package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="VENTA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pago", discriminatorType = DiscriminatorType.STRING)
public abstract class VentaEntity implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="idVenta")
	protected Integer idVenta;
	@Column (name="fecha")
	protected Date fecha;
	@Column (name="estado")
	protected String estado;
	@Column (name="observaciones")
	protected String observaciones;
	@Column (name="entregaInmediata")
	protected Boolean entregaInmediata;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCliente")
	protected ClienteEntity idCliente;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name= "idVenta")
	protected List<ItemVentaEntity> items;  
	
	public VentaEntity() {}

	public VentaEntity(Date fecha, String estado, String observaciones, Boolean entregaInmediata,
			ClienteEntity idCliente) {
		super();
		this.fecha = fecha;
		this.estado = estado;
		this.observaciones = observaciones;
		this.entregaInmediata = entregaInmediata;
		this.idCliente = idCliente;
	}
	
	public ClienteEntity getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(ClienteEntity idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Boolean getEntregaInmediata() {
		return entregaInmediata;
	}

	public void setEntregaInmediata(Boolean entregaInmediata) {
		this.entregaInmediata = entregaInmediata;
	}

	public List<ItemVentaEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemVentaEntity> items) {
		this.items = items;
	}
	
}
