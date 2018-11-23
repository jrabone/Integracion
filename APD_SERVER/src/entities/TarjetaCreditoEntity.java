package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TARJETA_DE_CREDITO")
public class TarjetaCreditoEntity extends VentaEntity {
	@Column(name="codigoConfMP")
	private String codigoConfirmacionMP;

	public String getCodigoConfirmacionMP() {
		return codigoConfirmacionMP;
	}

	public void setCodigoConfirmacionMP(String codigoConfirmacionMP) {
		this.codigoConfirmacionMP = codigoConfirmacionMP;
	}
	
	
}
