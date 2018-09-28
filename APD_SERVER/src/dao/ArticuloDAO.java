package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.ArticuloDTO;
import entities.ArticuloEntity;
import hbt.HibernateUtil;

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
	
	public ArticuloDTO toDTO(ArticuloEntity articulo) {
		ArticuloDTO articuloDTO = new ArticuloDTO();
		articuloDTO.setDescripcion(articulo.getDescripcion());
		articuloDTO.setFoto(articulo.getFoto());
		articuloDTO.setIdArticulo(articulo.getIdArticulo());
		articuloDTO.setPrecioUnitario(articulo.getPrecioUnitario());
		articuloDTO.setStock(articulo.getStock());
		return articuloDTO;
	}
}
