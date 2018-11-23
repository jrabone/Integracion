package negocio;

import java.util.Date;
import java.util.List;

import dao.VentaDAO;

public class Cheque extends Venta{
	private String numeroCheque;
	private String banco;
	private String titular;
	private String vencimiento;
	
	public Cheque(int idVenta, Date fecha, String estado, String observaciones,
			Boolean entregaInmediata, Cliente cliente, List<ItemVenta> items, String numeroCheque, String banco,
			String titular, String vencimiento) {
		super(idVenta, fecha, estado, observaciones, entregaInmediata, cliente, items);
		this.numeroCheque = numeroCheque;
		this.banco = banco;
		this.titular = titular;
		this.vencimiento = vencimiento;
	}

	public String getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}
	
	public Integer save() {
		return VentaDAO.getInstancia().save(this);
	}
	
	public void update() {
		VentaDAO.getInstancia().update(this);
	}
}
