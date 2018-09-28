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
	private int idDomicilio;
	@Column (name="pais")
	private String pais;
	@Column (name="provincia")
	private String provincia;
	@Column (name="partido")
	private String partido;
	@Column (name="codigoPostal")
	private String codigoPostal;
	@Column (name="calle")
	private String calle;
	@Column (name="altura")
	private String altura;
	@Column (name="piso")
	private String piso;
	@Column (name="numero")
	private int numero;
	
	public DomicilioEntity() {	}
	
	public DomicilioEntity(String pais, String provincia, String partido, String codigoPostal, String calle, String altura, String piso, int numero) {
		this.pais = pais;
		this.provincia = provincia;
		this.partido = partido;
		this.codigoPostal = codigoPostal;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.numero = numero;
	}
	
	//public DomicilioDeFacturacion toNegocio(){
		//return new DomicilioDeFacturacion(pais, provincia, partido, codigoPostal, calle, altura, piso, numero);
	//}
	
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
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
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
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
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
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
