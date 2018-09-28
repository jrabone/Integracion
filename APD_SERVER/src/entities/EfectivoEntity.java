package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EFECTIVO")
public class EfectivoEntity extends VentaEntity{

}
