package dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.VendedorDTO;
import entities.VendedorEntity;
import hbt.HibernateUtil;

public class VendedorDAO {
	private static VendedorDAO instancia;
	private SessionFactory sf;

	public VendedorDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static VendedorDAO getInstancia() {
		if (instancia == null) {
			instancia = new VendedorDAO();
		}
		return instancia;
	}

	public VendedorDTO loginUsuario(String email, String password) throws SQLException{
		VendedorDTO usuarioD = new VendedorDTO();
		Session session = sf.openSession();
		session.beginTransaction();
		VendedorEntity vendedorE = (VendedorEntity) session
				.createQuery("from VendedorEntity c where c.email = :email and c.password = :password")
				.setParameter("email",email)
				.setParameter("password",password).uniqueResult();
		session.getTransaction().commit();
		session.close();
		if (vendedorE == null){
			return null;
		}
		return toDTO(vendedorE);
	}
	
	public VendedorDTO toDTO(VendedorEntity vendedorEntity) {
		VendedorDTO vendedorDTO = new VendedorDTO();
		vendedorDTO.setApellido(vendedorEntity.getApellido());
		vendedorDTO.setEmail(vendedorEntity.getEmail());
		vendedorDTO.setIdVendedor(vendedorEntity.getIdVendedor());
		vendedorDTO.setNombre(vendedorEntity.getNombre());
		vendedorDTO.setPassword(vendedorEntity.getPassword());
		return vendedorDTO;
	}
}
