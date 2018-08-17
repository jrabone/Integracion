package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class ClienteEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="idCliente")
	private Integer idCliente;
	@Column (name="dni")
	private String dni;
	@Column (name="nombre")
	private String nombre;
	@Column (name="apellido")
	private String apellido;
	
	@OneToOne
	@JoinColumn(name="idDomicilioFacturacion")
	DomicilioEntity domicilioDeFacturacion;
	
	@OneToOne
	@JoinColumn(name="idDomicilioEntrega")
	DomicilioEntity domicilioDeEntrega;
	
	@OneToMany
	@JoinColumn(name="idVenta")
	List<VentaEntity> ventas;
	
	public ClienteEntity() {};
	
	public ClienteEntity(String dni, String nombre, String apellido,
			DomicilioEntity domicilioDeFacturacion, DomicilioEntity domicilioDeEntrega, List<VentaEntity> ventas) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilioDeFacturacion = domicilioDeFacturacion;
		this.domicilioDeEntrega = domicilioDeEntrega;
		this.ventas = ventas;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
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

	public DomicilioEntity getDomicilioDeFacturacion() {
		return domicilioDeFacturacion;
	}

	public void setDomicilioDeFacturacion(DomicilioEntity domicilioDeFacturacion) {
		this.domicilioDeFacturacion = domicilioDeFacturacion;
	}

	public DomicilioEntity getDomicilioDeEntrega() {
		return domicilioDeEntrega;
	}

	public void setDomicilioDeEntrega(DomicilioEntity domicilioDeEntrega) {
		this.domicilioDeEntrega = domicilioDeEntrega;
	}

	public List<VentaEntity> getVentas() {
		return ventas;
	}

	public void setVentas(List<VentaEntity> ventas) {
		this.ventas = ventas;
	}	
	
}
