package negocio;

public class Domicilio {

	private int idDomicilio;
	private String pais;
	private String provincia;
	private String localidad;
	private String codigoPostal;
	private String calle;
	private int numero;
	private String piso;
	private String dpto;
	
	public Domicilio(int idDomicilio, String pais, String provincia, String localidad,
			String codigoPostal, String calle, int numero, String piso, String dpto) {
		this.idDomicilio = idDomicilio;
		this.pais = pais;
		this.provincia = provincia;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.dpto = dpto;
	}
	
	public String getDireccionCompleta() {
		return calle + " " + numero + " " + " " + piso + " " + dpto + " - " + localidad + " - " + provincia; 
	}
	
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
	public String getDpto() {
		return dpto;
	}
	public void setDpto(String dpto) {
		this.dpto = dpto;
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
