package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Venta {
	protected int idVenta;
	protected Date fecha;
	protected String estado;
	protected String observaciones;
	protected Boolean entregaInmediata;
	protected Cliente cliente;
	protected List<ItemVenta> items;
	
	public Venta(int idVenta, Date fecha, String estado, String observaciones,
			Boolean entregaInmediata, Cliente cliente, List<ItemVenta> items) {
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.estado = estado;
		this.observaciones = observaciones;
		this.entregaInmediata = entregaInmediata;
		this.cliente = cliente;
		this.items = items;
	}
	
	public void actualizarEstado(String estado) {
		this.estado = estado;
		this.update();
	}
	
	public double getTotal() {
		double total = 0;
		for(ItemVenta item : items) {
			total += item.getSubtotal();
		}
		return total;
		
	}
	
	public void agregarItem(Articulo articulo, double cantidad) {
		if (this.items == null) {
			this.items = new ArrayList<ItemVenta>();
		}
		ItemVenta item = new ItemVenta(articulo, cantidad);
		this.items.add(item);
		this.save();
	}

	public List<ItemVenta> getItems() {
		return items;
	}

	public void setItems(List<ItemVenta> items) {
		this.items = items;
	}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public abstract Integer save();
	
	public abstract void update();

}
