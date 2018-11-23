package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOMICILIO")
public class DomicilioEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="idDomicilio")
	private Integer idDomicilio;
	@Column (name="pais")
	private String pais;
	@Column (name="provincia")
	private String provincia;
	@Column (name="localidad")
	private String localidad;
	@Column (name="codigoPostal")
	private String codigoPostal;
	@Column (name="calle")
	private String calle;
	@Column (name="piso")
	private String piso;
	@Column (name="numero")
	private int numero;
	@Column (name="dpto")
	private String dpto;
	
	public DomicilioEntity() {	}
	
	public DomicilioEntity(String pais, String provincia, String localidad, String codigoPostal, String calle, String piso, int numero, String dpto) {
		this.pais = pais;
		this.provincia = provincia;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
		this.calle = calle;
		this.piso = piso;
		this.numero = numero;
		this.dpto = dpto;
	}
	
	//public DomicilioDeFacturacion toNegocio(){
		//return new DomicilioDeFacturacion(pais, provincia, partido, codigoPostal, calle, altura, piso, numero);
	//}
	
	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public int getNumero() {
		return numero;
	}
	public void getNumero(int numero) {
		this.numero = numero;
	}

	public int getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
}
