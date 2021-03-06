package hbt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.ArticuloEntity;
import entities.ChequeEntity;
import entities.ClienteEntity;
import entities.DomicilioEntity;
import entities.EfectivoEntity;
import entities.ItemVentaEntity;
import entities.TarjetaCreditoEntity;
import entities.VendedorEntity;
import entities.VentaEntity;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static Session session;

	static {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();

			config.addAnnotatedClass(ClienteEntity.class);
			config.addAnnotatedClass(DomicilioEntity.class);
			config.addAnnotatedClass(VendedorEntity.class);
			config.addAnnotatedClass(VentaEntity.class);
			config.addAnnotatedClass(ChequeEntity.class);
			config.addAnnotatedClass(EfectivoEntity.class);
			config.addAnnotatedClass(TarjetaCreditoEntity.class);
			config.addAnnotatedClass(ItemVentaEntity.class);
			config.addAnnotatedClass(ArticuloEntity.class);
			
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		return session;
	}

}
