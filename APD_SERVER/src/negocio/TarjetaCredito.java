package negocio;

import java.util.Date;
import java.util.List;

import dao.VentaDAO;

public class TarjetaCredito extends Venta{
	private String codigoConfirmacionMP;
	
	public TarjetaCredito(int idVenta, Date fecha, String estado, String observaciones,
			Boolean entregaInmediata, Cliente cliente, List<ItemVenta> items, String codigoConfirmacionMP) {
		super(idVenta, fecha, estado, observaciones, entregaInmediata, cliente, items);
		this.codigoConfirmacionMP = codigoConfirmacionMP;
	}
	
	public void actualizarEstado(String estado, String codigoConfirmacionMP) {
		this.estado = estado;
		this.codigoConfirmacionMP = codigoConfirmacionMP;
		this.update();
	}
	
	public String getCodigoConfirmacionMP() {
		return codigoConfirmacionMP;
	}


	public void setCodigoConfirmacionMP(String codigoConfirmacionMP) {
		this.codigoConfirmacionMP = codigoConfirmacionMP;
	}


	public Integer save() {
		return VentaDAO.getInstancia().save(this);
	}
	
	public void update() {
		VentaDAO.getInstancia().update(this);
	}

}
