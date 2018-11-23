package negocio;

import java.util.Date;
import java.util.List;

import dao.VentaDAO;

public class Efectivo extends Venta{
	public Efectivo(int idVenta, Date fecha, String estado, String observaciones,
			Boolean entregaInmediata, Cliente cliente, List<ItemVenta> items) {
		super(idVenta, fecha, estado, observaciones, entregaInmediata, cliente, items);
	}
	
	public Integer save() {
		return VentaDAO.getInstancia().save(this);
	}
	
	public void update() {
		VentaDAO.getInstancia().update(this);
	}
}
