package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.ClienteDTO;
import dto.DomicilioDTO;
import entities.ArticuloEntity;
import entities.ClienteEntity;
import entities.DomicilioEntity;
import exception.ComunicationException;
import hbt.HibernateUtil;
import negocio.Cliente;
import negocio.Domicilio;
import negocio.Venta;

public class ClienteDAO {
	private static ClienteDAO instancia;
	private SessionFactory sf;

	public ClienteDAO() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static ClienteDAO getInstancia() {
		if (instancia == null) {
			instancia = new ClienteDAO();
		}
		return instancia;
	}
	
	public ClienteDTO buscarClienteById(String dni) throws ComunicationException{
		ClienteEntity cliente = null;
		try {
		Session session = sf.openSession();
		session.beginTransaction();
		cliente = (ClienteEntity) session.createQuery("from ClienteEntity c where c.dni = :dni ")
				.setParameter("dni", dni).uniqueResult();
		session.getTransaction().commit();
		session.close();
		if (cliente == null){
			return null;
		}
		}catch(Exception e) {
			new ComunicationException("Error en buscar paseador en BD, reintente");
		}
		return toDTO(cliente);
	}
	
	public void save(Cliente cliente) {
		ClienteEntity clienteEntity = toEntity(cliente);
		try {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(clienteEntity);
		s.getTransaction().commit();
		s.close();
		}catch(Exception e) {
			new ComunicationException("Error grabar cliente en BD, reintente");
		}
	}
	
	public ClienteDTO toDTO(ClienteEntity cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setApellido(cliente.getApellido());
		clienteDTO.setDni(cliente.getDni());
		clienteDTO.setDomicilioDeEntrega(toDTO(cliente.getDomicilioDeEntrega()));
		clienteDTO.setDomicilioDeFacturacion(toDTO(cliente.getDomicilioDeFacturacion()));
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setNombre(cliente.getNombre());
		return clienteDTO;
	}
	
	public Cliente toNegocio(ClienteDTO cliente) {
		Cliente clienteNegocio = new Cliente(cliente.getIdCliente(), cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getCelular(), toNegocio(cliente.getDomicilioDeFacturacion()), toNegocio(cliente.getDomicilioDeEntrega()), null);
		return clienteNegocio;
	}

	
	public DomicilioDTO toDTO(DomicilioEntity domicilio) {
		DomicilioDTO domicilioDTO = new DomicilioDTO();
		domicilioDTO.setCalle(domicilio.getCalle());
		domicilioDTO.setCodigoPostal(domicilio.getCodigoPostal());
		domicilioDTO.setDpto(domicilio.getDpto());
		domicilioDTO.setIdDomicilio(domicilio.getIdDomicilio());
		domicilioDTO.setLocalidad(domicilio.getLocalidad());
		domicilioDTO.setNumero(domicilio.getNumero());
		domicilioDTO.setPais(domicilio.getPais());
		domicilioDTO.setPiso(domicilio.getPiso());
		domicilioDTO.setProvincia(domicilio.getProvincia());
		return domicilioDTO;
		
	}
	public ClienteEntity toEntity(Cliente cliente ) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setIdCliente(cliente.getIdCliente());
		clienteEntity.setApellido(cliente.getApellido());
		clienteEntity.setDni(cliente.getDni());
		clienteEntity.setNombre(cliente.getNombre());
		clienteEntity.setDomicilioDeEntrega(toEntity(cliente.getDomicilioDeEntrega()));
		clienteEntity.setDomicilioDeFacturacion(toEntity(cliente.getDomicilioDeFacturacion()));
		return clienteEntity;
	}
	
	public Domicilio toNegocio(DomicilioDTO domicilio) {
		Domicilio aux = new Domicilio(domicilio.getIdDomicilio(), domicilio.getPais(), domicilio.getProvincia(), domicilio.getLocalidad(),
				domicilio.getCodigoPostal(), domicilio.getCalle(), domicilio.getNumero(), domicilio.getPiso(), domicilio.getDpto());
		return aux;
	}
	

	
	public DomicilioEntity toEntity(Domicilio domicilio) {
		DomicilioEntity domicilioEntity = new DomicilioEntity();
		domicilioEntity.setCalle(domicilio.getCalle());
		domicilioEntity.setCodigoPostal(domicilio.getCodigoPostal());
		domicilioEntity.setNumero(domicilio.getNumero());
		domicilioEntity.setPais(domicilio.getPais());
		domicilioEntity.setLocalidad(domicilio.getLocalidad());
		domicilioEntity.setPiso(domicilio.getPiso());
		domicilioEntity.setProvincia(domicilio.getProvincia());
		return domicilioEntity;
	}
}
