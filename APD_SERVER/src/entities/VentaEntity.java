package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VENTA")
public class VentaEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="idVenta")
	private Integer idVenta;
	@Column (name="fecha")
	protected Date fecha;
	@Column (name="estado")
	private String estado;
	@Column (name="observaciones")
	private String observaciones;
	@Column (name="entregaInmediata")
	private Boolean entregaInmediata;
	@ManyToOne
	@JoinColumn (name="idCliente")
	protected ClienteEntity idCliente;
	
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
	
	
	
	
}
