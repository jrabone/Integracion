package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


import entities.ClienteEntity;
import entities.DomicilioEntity;
import entities.VendedorEntity;
import entities.VentaEntity;

public class HibernateUtil
{
    private static final SessionFactory sessionFactory;

    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
             config.addAnnotatedClass(ClienteEntity.class);
             config.addAnnotatedClass(DomicilioEntity.class); 
             config.addAnnotatedClass(VendedorEntity.class); 
             config.addAnnotatedClass(VentaEntity.class); 
             //TODO Agregar todas las entities----
             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
