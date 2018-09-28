package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class VentaDTO implements Serializable{
	protected int idVenta;
	protected Date fecha;
	protected String estado;
	protected String observaciones;
	protected Boolean entregaInmediata;
	protected ClienteDTO cliente;
	protected List<ItemVentaDTO> items;
	
	public VentaDTO() {}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
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

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public List<ItemVentaDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemVentaDTO> items) {
		this.items = items;
	}
}
