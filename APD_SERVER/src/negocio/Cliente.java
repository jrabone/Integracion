package negocio;

import java.util.List;

import dao.ClienteDAO;

public class Cliente {

	private int idCliente;
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String celular;
	private Domicilio domicilioDeFacturacion;
	private Domicilio domicilioDeEntrega;
	private List<Venta> ventas;
	
	public Cliente(int idCliente, String dni, String nombre, String apellido, String telefono, String celular,
			Domicilio domicilioDeFacturacion, Domicilio domicilioDeEntrega, 
			List<Venta> ventas) {
		this.idCliente = idCliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilioDeFacturacion = domicilioDeFacturacion;
		this.domicilioDeEntrega = domicilioDeEntrega;
		this.ventas = ventas;
		this.telefono = telefono;
		this.celular = celular;
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
	
	
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void save() {
		ClienteDAO.getInstancia().save(this);
	}
	
}
