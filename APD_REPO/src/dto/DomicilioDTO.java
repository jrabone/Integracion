package dto;

import java.io.Serializable;

public class DomicilioDTO implements Serializable{
	private int idDomicilio;
	private String pais;
	private String provincia;
	private String localidad;
	private String codigoPostal;
	private String calle;
	private int numero;
	private String piso;
	private String dpto;
	
	public DomicilioDTO() {}

	public int getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
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

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
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

	public int getNumero() {
		return numero;
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

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}
	
	public String getDomicilioCompleto() {
		if (piso == null)
		return (calle + " "  + numero + " " + localidad + " (" + codigoPostal + ")" + " " + provincia + ", " + pais);
		else
			return (calle + " "  + numero + " Piso " + piso + " Dpto " + dpto + " " + localidad + "(" + codigoPostal + ")" + " " + provincia + ", " + pais);
	}
}
