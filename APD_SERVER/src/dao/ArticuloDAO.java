package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.ArticuloDTO;
import entities.ArticuloEntity;
import hbt.HibernateUtil;
import negocio.Articulo;

public class ArticuloDAO {
	private static ArticuloDAO instancia;
	private SessionFactory sf;

	public ArticuloDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static ArticuloDAO getInstancia() {
		if (instancia == null) {
			instancia = new ArticuloDAO();
		}
		return instancia;
	}
	
	public List<ArticuloDTO> buscarArticulos() throws SQLException{
		Session session = sf.openSession();
		session.beginTransaction();
		List<ArticuloEntity> articulos = (List<ArticuloEntity>) session.createQuery("from ArticuloEntity c").list();
		session.getTransaction().commit();
		session.close();
		
		List<ArticuloDTO> articulosDTO = new ArrayList<ArticuloDTO>();
		for(ArticuloEntity articulo : articulos) {
			articulosDTO.add(toDTO(articulo));
		}
		
		return articulosDTO;
	}
	
	public Integer grabar(Articulo articulo){
		ArticuloEntity ae = new ArticuloEntity(articulo);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(ae);
		session.getTransaction().commit();
		session.close();
		return ae.toNegocio().getIdArticulo();
	}
	
	public ArticuloDTO toDTO(ArticuloEntity articulo) {
		ArticuloDTO articuloDTO = new ArticuloDTO();
		articuloDTO.setDescripcion(articulo.getDescripcion());
		articuloDTO.setFoto(articulo.getFoto());
		articuloDTO.setIdArticulo(articulo.getIdArticulo());
		articuloDTO.setPrecioUnitario(articulo.getPrecioUnitario());
		articuloDTO.setStock(articulo.getStock());
		return articuloDTO;
	}
	
	public Articulo toNegocio(ArticuloDTO articulo) {
		Articulo articuloNegocio = new Articulo(articulo.getIdArticulo(), articulo.getDescripcion(), articulo.getPrecioUnitario(), articulo.getFoto(), articulo.getStock());
		return articuloNegocio;
	}
	
	public ArticuloEntity toEntity(Articulo articulo) {
		ArticuloEntity aux = new ArticuloEntity();
		aux.setDescripcion(articulo.getDescripcion());
		aux.setFoto(articulo.getFoto());
		aux.setIdArticulo(articulo.getIdArticulo());
		aux.setPrecioUnitario(articulo.getPrecioUnitario());
		aux.setStock(articulo.getStock());
		return aux;
	}
}
