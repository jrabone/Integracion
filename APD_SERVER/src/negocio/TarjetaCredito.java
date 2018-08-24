package negocio;

import java.util.Date;
import java.util.List;

public class TarjetaCredito extends Venta{
	private String numero;
	private String vencimiento;
	private String titular;
	private String dni;
	
	public TarjetaCredito(int idVenta, Date fecha, String estado, String observaciones,
			Boolean entregaInmediata, Cliente cliente, List<ItemVenta> items, String numero, String vencimiento,
			String titular, String dni) {
		super(idVenta, fecha, estado, observaciones, entregaInmediata, cliente, items);
		this.numero = numero;
		this.vencimiento = vencimiento;
		this.titular = titular;
		this.dni = dni;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
