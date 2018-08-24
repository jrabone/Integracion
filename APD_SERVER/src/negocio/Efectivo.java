package negocio;

import java.util.Date;
import java.util.List;

public class Efectivo extends Venta{
	public Efectivo(int idVenta, Date fecha, String estado, String observaciones,
			Boolean entregaInmediata, Cliente cliente, List<ItemVenta> items) {
		super(idVenta, fecha, estado, observaciones, entregaInmediata, cliente, items);
		
	}
}
