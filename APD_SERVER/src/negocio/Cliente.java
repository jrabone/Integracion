package negocio;

import java.util.List;

public class Cliente {

	private int idCliente;
	private String dni;
	private String nombre;
	private String apellido;
	private Domicilio domicilioDeFacturacion;
	private Domicilio domicilioDeEntrega;
	private List<Venta> ventas;
	
	public Cliente(int idCliente, String dni, String nombre, String apellido,
			Domicilio domicilioDeFacturacion, Domicilio domicilioDeEntrega, 
			List<Venta> ventas) {
		this.idCliente = idCliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilioDeFacturacion = domicilioDeFacturacion;
		this.domicilioDeEntrega = domicilioDeEntrega;
		this.ventas = ventas;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Domicilio getDomicilioDeFacturacion() {
		return domicilioDeFacturacion;
	}
	public void setDomicilioDeFacturacion(Domicilio domicilioDeFacturacion) {
		this.domicilioDeFacturacion = domicilioDeFacturacion;
	}
	public Domicilio getDomicilioDeEntrega() {
		return domicilioDeEntrega;
	}
	public void setDomicilioDeEntrega(Domicilio domicilioDeEntrega) {
		this.domicilioDeEntrega = domicilioDeEntrega;
	}
	public List<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
	
}
