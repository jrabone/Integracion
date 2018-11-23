package dto;

import java.io.Serializable;

public class TarjetaCreditoDTO extends VentaDTO implements Serializable{
	private String codigoConfirmacionMP;
	
	public TarjetaCreditoDTO() {}

	public String getCodigoConfirmacionMP() {
		return codigoConfirmacionMP;
	}

	public void setCodigoConfirmacionMP(String codigoConfirmacionMP) {
		this.codigoConfirmacionMP = codigoConfirmacionMP;
	}
	
	
}
