package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.ArticuloDTO;
import dto.ChequeDTO;
import dto.ItemVentaDTO;
import dto.VentaDTO;
import entities.ArticuloEntity;
import entities.ChequeEntity;
import entities.EfectivoEntity;
import entities.ItemVentaEntity;
import entities.TarjetaCreditoEntity;
import entities.VentaEntity;
import exception.ComunicationException;
import hbt.HibernateUtil;
import negocio.Cheque;
import negocio.Efectivo;
import negocio.ItemVenta;
import negocio.TarjetaCredito;
import negocio.Venta;

public class VentaDAO {
	private static VentaDAO instancia;
	private SessionFactory sf;

	public VentaDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static VentaDAO getInstancia() {
		if (instancia == null) {
			instancia = new VentaDAO();
		}
		return instancia;
	}
	
	public Integer save(Venta venta) {
		Integer nro = 0;
		try {
			if(venta instanceof Efectivo) {
				EfectivoEntity aux = toEntity((Efectivo) venta);
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session s = sf.openSession();
				s.beginTransaction();
				nro = (Integer) s.save(aux);
				s.getTransaction().commit();
				s.close();
			}else {
				if(venta instanceof Cheque) {
					ChequeEntity aux = toEntity((Cheque) venta);
					SessionFactory sf = HibernateUtil.getSessionFactory();
					Session s = sf.openSession();
					s.beginTransaction();
					nro = (Integer) s.save(aux);
					s.getTransaction().commit();
					s.close();
				}if(venta instanceof TarjetaCredito) {
					TarjetaCreditoEntity aux = toEntity((TarjetaCredito) venta);
					SessionFactory sf = HibernateUtil.getSessionFactory();
					Session s = sf.openSession();
					s.beginTransaction();
					nro = (Integer) s.save(aux);
					s.getTransaction().commit();
					s.close();
					return nro;
				}
			}
			return nro;
		}catch(Exception e) {
			new ComunicationException("Error en grabar venta en BD, reintente");
			return nro;
		}
	}
	
	public int update(Venta venta) {
		int nro = 0;
		try {
			if(venta instanceof Efectivo) {
				EfectivoEntity aux = toEntity((Efectivo) venta);
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session s = sf.openSession();
				s.beginTransaction();
				s.update(aux);
				s.getTransaction().commit();
				s.close();
			}else {
				if(venta instanceof Cheque) {
					ChequeEntity aux = toEntity((Cheque) venta);
					SessionFactory sf = HibernateUtil.getSessionFactory();
					Session s = sf.openSession();
					s.beginTransaction();
					s.update(aux);
					s.getTransaction().commit();
					s.close();
				}if(venta instanceof TarjetaCredito) {
					TarjetaCreditoEntity aux = toEntity((TarjetaCredito) venta);
					SessionFactory sf = HibernateUtil.getSessionFactory();
					Session s = sf.openSession();
					s.beginTransaction();
					s.update(aux);
					s.getTransaction().commit();
					s.close();
				}
			}
			return nro;
		}catch(Exception e) {
			new ComunicationException("Error en grabar venta en BD, reintente");
			return nro;
		}
	}
	
	public EfectivoEntity toEntity(Efectivo efectivo) {
		EfectivoEntity aux = new EfectivoEntity();
		aux.setEntregaInmediata(efectivo.getEntregaInmediata());
		aux.setEstado(efectivo.getEstado());
		aux.setFecha(efectivo.getFecha());
		aux.setIdCliente(ClienteDAO.getInstancia().toEntity(efectivo.getCliente()));
		List<ItemVentaEntity> items = new ArrayList<ItemVentaEntity>();
		for(ItemVenta item : efectivo.getItems()) {
			items.add(toEntity(item));
		}
		//aux.setItems(items);
		aux.setObservaciones("323");
	//	aux.setObservaciones(efectivo.getObservaciones());
		return aux;
	}
	
	public ChequeEntity toEntity(Cheque cheque) {
		ChequeEntity aux = new ChequeEntity();
		aux.setEntregaInmediata(false);
		aux.setEstado(cheque.getEstado());
		aux.setFecha(cheque.getFecha());
		aux.setIdVenta(0);
		aux.setIdCliente(ClienteDAO.getInstancia().toEntity(cheque.getCliente()));
		List<ItemVentaEntity> items = new ArrayList<ItemVentaEntity>();
		for(ItemVenta item : cheque.getItems()) {
			items.add(toEntity(item));
		}
		aux.setItems(items);
		aux.setBanco(cheque.getBanco());
		aux.setNumeroCheque(cheque.getNumeroCheque());
		aux.setObservaciones(cheque.getObservaciones());
		aux.setTitular(cheque.getTitular());
		aux.setVencimiento(cheque.getVencimiento());
		return aux;
	}
	
	public TarjetaCreditoEntity toEntity(TarjetaCredito tarjeta) {
		TarjetaCreditoEntity aux = new TarjetaCreditoEntity();
		aux.setEntregaInmediata(tarjeta.getEntregaInmediata());
		aux.setEstado(tarjeta.getEstado());
		aux.setFecha(tarjeta.getFecha());
		aux.setIdCliente(ClienteDAO.getInstancia().toEntity(tarjeta.getCliente()));
		List<ItemVentaEntity> items = new ArrayList<ItemVentaEntity>();
		for(ItemVenta item : tarjeta.getItems()) {
			items.add(toEntity(item));
		}
		aux.setItems(items);
		aux.setObservaciones(tarjeta.getObservaciones());
		aux.setCodigoConfirmacionMP(tarjeta.getCodigoConfirmacionMP());
		return aux;
	}
	
	public ItemVentaEntity toEntity(ItemVenta item) {
		ItemVentaEntity aux = new ItemVentaEntity();
		aux.setArticulo(ArticuloDAO.getInstancia().toEntity(item.getArticulo()));
		aux.setCantidad(item.getCantidad());
		return aux;
	}
	
	public ItemVenta toNegocio(ItemVentaDTO item) {
		ItemVenta itemVenta = new ItemVenta(ArticuloDAO.getInstancia().toNegocio(item.getArticulo()), item.getCantidad());
		return itemVenta;
	}

	public VentaDTO buscarVenta(int idVenta) {
		Session session = sf.openSession();
		session.beginTransaction();
		VentaEntity venta = (VentaEntity) session.createQuery("from VentaEntity c where c.idVenta = :idVenta")
				.setParameter("idVenta", idVenta).uniqueResult();
		session.getTransaction().commit();
		session.close();
		VentaDTO devolver = null;
		
		if (venta instanceof ChequeEntity) {
			devolver = toDTO((ChequeEntity) venta);
		}
		
		return devolver;
	}
	
	public ChequeDTO toDTO(ChequeEntity cheque){
		ChequeDTO aux = new ChequeDTO();
		aux.setBanco(cheque.getBanco());
		aux.setCliente(ClienteDAO.getInstancia().toDTO(cheque.getIdCliente()));
		aux.setEntregaInmediata(cheque.getEntregaInmediata());
		aux.setEstado(cheque.getEstado());
		aux.setFecha(cheque.getFecha());
		aux.setIdVenta(cheque.getIdVenta());
		aux.setNumeroCheque(cheque.getNumeroCheque());
		aux.setObservaciones(cheque.getObservaciones());
		aux.setTitular(cheque.getTitular());
		aux.setVencimiento(cheque.getVencimiento());
		List<ItemVentaDTO> items = new ArrayList<ItemVentaDTO>();
		for(ItemVentaEntity item : cheque.getItems()) {
			items.add(VentaDAO.getInstancia().toDTO(item));
		}
		aux.setItems(items);
		return aux;
	}
	
	public ItemVentaDTO toDTO(ItemVentaEntity item) {
		ItemVentaDTO aux = new ItemVentaDTO();
		aux.setArticulo(ArticuloDAO.getInstancia().toDTO(item.getArticulo()));
		aux.setCantidad(item.getCantidad());
		return aux;
	}

}
