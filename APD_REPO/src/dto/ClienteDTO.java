package dto;

import java.io.Serializable;
import java.util.List;

public class ClienteDTO implements Serializable{
	private int idCliente;
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String celular;
	private DomicilioDTO domicilioDeFacturacion;
	private DomicilioDTO domicilioDeEntrega;
	private List<VentaDTO> ventas;
	
	public ClienteDTO() {}

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

	public DomicilioDTO getDomicilioDeFacturacion() {
		return domicilioDeFacturacion;
	}

	public void setDomicilioDeFacturacion(DomicilioDTO domicilioDeFacturacion) {
		this.domicilioDeFacturacion = domicilioDeFacturacion;
	}

	public DomicilioDTO getDomicilioDeEntrega() {
		return domicilioDeEntrega;
	}

	public void setDomicilioDeEntrega(DomicilioDTO domicilioDeEntrega) {
		this.domicilioDeEntrega = domicilioDeEntrega;
	}

	public List<VentaDTO> getVentas() {
		return ventas;
	}

	public void setVentas(List<VentaDTO> ventas) {
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
	
	

}
