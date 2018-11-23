package servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delegado.BusinessDelegate;
import dto.ArticuloDTO;
import dto.ChequeDTO;
import dto.ClienteDTO;
import dto.DomicilioDTO;
import dto.ItemVentaDTO;
import dto.VendedorDTO;



@WebServlet("/servlets/ServletModuloVentas")
public class ServletModuloVentas extends HttpServlet{
	private static final long serialVersionUID = -2995544905709948607L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			HttpSession session = request.getSession();
			
			if(request.getParameter("action").equalsIgnoreCase("loginUsuarios")){
				
				RequestDispatcher dispatcher;
				try {
				
	    		VendedorDTO usuario = null;
	    		String email = ((String)request.getParameter("email"));
	    		String password = ((String)request.getParameter("password"));
	    		
					usuario = BusinessDelegate.getInstancia().loginUsuario(email, password);
					if(usuario != null) {
						request.setAttribute("error", "Login OK!!!");
						
						List<ArticuloDTO> articulos = BusinessDelegate.getInstancia().listarArticulos();
						request.setAttribute("articulos", articulos);
						List<ArticuloDTO> carrito = new ArrayList<ArticuloDTO>();
						session.setAttribute("articulos",  articulos);
						session.setAttribute("carrito", carrito);
						session.setAttribute("vendedor", usuario);
						dispatcher=request.getRequestDispatcher("/main.jsp");
						dispatcher.forward(request, response);	
					}else {
						
						request.setAttribute("error", "Usuario o password invalido");
						
						dispatcher=request.getRequestDispatcher("/login.jsp");
			    		dispatcher.forward(request, response);
						
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				if(request.getParameter("action").equalsIgnoreCase("cerrarSesion")) {
					RequestDispatcher dispatcher;
					session.removeAttribute("vendedor");
					session.removeAttribute("carrito");
					dispatcher=request.getRequestDispatcher("/login.jsp");
		    		dispatcher.forward(request, response);
				}else {
					if(request.getParameter("action").equalsIgnoreCase("agregarArticuloCarrito")) {
						RequestDispatcher dispatcher;
						try {
						List<ArticuloDTO> articulos = BusinessDelegate.getInstancia().listarArticulos();
						request.setAttribute("articulos", articulos);
						List<ArticuloDTO> carrito = (List<ArticuloDTO>)session.getAttribute("carrito");
						ArticuloDTO articulo = new ArticuloDTO();
						articulo.setIdArticulo(Integer.parseInt(request.getParameter("idArticulo")));
						articulo.setDescripcion(request.getParameter("descripcionArticulo"));
						articulo.setPrecioUnitario(Double.parseDouble(request.getParameter("precioArticulo")));
						carrito.add(articulo);
						session.setAttribute("carrito", carrito);
						
						dispatcher=request.getRequestDispatcher("/main.jsp");
						dispatcher.forward(request, response);	
						
						}catch (Exception e) {
							e.printStackTrace();
							
						}
					}else {
						if(request.getParameter("action").equalsIgnoreCase("verCarrito")) {
							RequestDispatcher dispatcher;
							try {
								dispatcher=request.getRequestDispatcher("/verCarrito.jsp");
								dispatcher.forward(request, response);	
								
							}catch (Exception e) {
								e.printStackTrace();
								
							}
							
						}else {
							if(request.getParameter("action").equalsIgnoreCase("vaciarCarrito")) {
								RequestDispatcher dispatcher;
								try {
									
									session.removeAttribute("carrito");
									session.removeAttribute("cliente");
									List<ArticuloDTO> articulos = BusinessDelegate.getInstancia().listarArticulos();
									request.setAttribute("articulos", articulos);
									List<ArticuloDTO> carrito = new ArrayList<ArticuloDTO>();
									session.setAttribute("carrito", carrito);
									dispatcher=request.getRequestDispatcher("/main.jsp");
									dispatcher.forward(request, response);	
									
								}catch (Exception e) {
									e.printStackTrace();
									
								}
							}
							else {
								if(request.getParameter("action").equalsIgnoreCase("eliminarDelCarrito")) {
									RequestDispatcher dispatcher;
									List<ArticuloDTO> carrito = (List<ArticuloDTO>)session.getAttribute("carrito");
									ArticuloDTO artAEliminar = null;
									int idArticulo = Integer.parseInt(request.getParameter("idArticulo"));
									for (ArticuloDTO art : carrito) {
										if (art.getIdArticulo().equals(idArticulo)) {
											artAEliminar = art;
										}
									}

									carrito.remove(artAEliminar);
									session.setAttribute("carrito", carrito);
									
									dispatcher=request.getRequestDispatcher("/verCarrito.jsp");
									dispatcher.forward(request, response);
								}else {
									if(request.getParameter("action").equalsIgnoreCase("listarArticulos")) {
										RequestDispatcher dispatcher;
										try {
										List<ArticuloDTO> articulos = BusinessDelegate.getInstancia().listarArticulos();
										request.setAttribute("articulos", articulos);
										dispatcher=request.getRequestDispatcher("/main.jsp");
										dispatcher.forward(request, response);	
										
										}catch (Exception e) {
											e.printStackTrace();
											
										}
									}else {
										if(request.getParameter("action").equalsIgnoreCase("altaCliente")) {
											RequestDispatcher dispatcher;
											try {
											dispatcher=request.getRequestDispatcher("/altaCliente.jsp");
											dispatcher.forward(request, response);	
											
											}catch (Exception e) {
												e.printStackTrace();
												
											}
										}else {
											if(request.getParameter("action").equalsIgnoreCase("procesarAltaCliente")) {
												RequestDispatcher dispatcher;
												try {
												ClienteDTO cliente = new ClienteDTO();
												String nombre = ((String)request.getParameter("nombre"));
												String apellido = ((String)request.getParameter("apellido"));
												String dni = ((String)request.getParameter("dni"));
												String telefono = ((String)request.getParameter("telefono"));
												String celular = ((String)request.getParameter("celular"));
												cliente.setApellido(apellido);
												cliente.setDni(dni);
												cliente.setNombre(nombre);
												cliente.setTelefono(telefono);
												cliente.setCelular(celular);
												DomicilioDTO domicilioFacturacion = new DomicilioDTO();
												String FacturacionCalle = ((String)request.getParameter("FacturacionCalle"));
												int FacturacionNumero = Integer.parseInt((String)request.getParameter("FacturacionNumero"));
												String FacturacionPiso = ((String)request.getParameter("FacturacionPiso"));
												String FacturacionDepto = ((String)request.getParameter("FacturacionDpto"));
												String FacturacionLocalidad = ((String)request.getParameter("FacturacionLocalidad"));
												String FacturacionCodigoPostal = ((String)request.getParameter("FacturacionCodigoPostal"));
												String FacturacionProvincia = ((String)request.getParameter("FacturacionProvincia"));
												String FacturacionPais = ((String)request.getParameter("FacturacionPais"));
												domicilioFacturacion.setCalle(FacturacionCalle);
												domicilioFacturacion.setCodigoPostal(FacturacionCodigoPostal);
												domicilioFacturacion.setDpto(FacturacionDepto);
												domicilioFacturacion.setLocalidad(FacturacionLocalidad);
												domicilioFacturacion.setNumero(FacturacionNumero);
												domicilioFacturacion.setPais(FacturacionPais);
												domicilioFacturacion.setPiso(FacturacionPiso);
												domicilioFacturacion.setProvincia(FacturacionProvincia);
												
												DomicilioDTO domicilioEntrega = new DomicilioDTO();
												String EntregaCalle = ((String)request.getParameter("EntregaCalle"));
												int EntregaNumero = Integer.parseInt((String) request.getParameter("EntregaNumero"));
												String EntregaPiso = ((String)request.getParameter("EntregaPiso"));
												String EntregaDepto = ((String)request.getParameter("EntregaDpto"));
												String EntregaLocalidad = ((String)request.getParameter("EntregaLocalidad"));
												String EntregaCodigoPostal = ((String)request.getParameter("EntregaCodigoPostal"));
												String EntregaProvincia = ((String)request.getParameter("EntregaProvincia"));
												String EntregaPais = ((String)request.getParameter("EntregaPais"));
												domicilioEntrega.setCalle(EntregaCalle);
												domicilioEntrega.setCodigoPostal(EntregaCodigoPostal);
												domicilioEntrega.setDpto(EntregaDepto);
												domicilioEntrega.setLocalidad(EntregaLocalidad);
												domicilioEntrega.setNumero(EntregaNumero);
												domicilioEntrega.setPais(EntregaPais);
												domicilioEntrega.setPiso(EntregaPiso);
												domicilioEntrega.setProvincia(EntregaProvincia);
												domicilioEntrega.setProvincia(EntregaProvincia);
												
												cliente.setDomicilioDeEntrega(domicilioEntrega);
												cliente.setDomicilioDeFacturacion(domicilioFacturacion);
												
												BusinessDelegate.getInstancia().altaCliente(cliente); // Hago el alta
												
												cliente = BusinessDelegate.getInstancia().buscarClienteByDni(dni); // Lo voy a buscar
												session.setAttribute("cliente", cliente);

												dispatcher=request.getRequestDispatcher("/verCarrito.jsp");
												dispatcher.forward(request, response);	
												
												}catch (Exception e) {
													e.printStackTrace();
													
												}
											}else {
												if(request.getParameter("action").equalsIgnoreCase("ingresoCliente")) {
													RequestDispatcher dispatcher;
													try {
														String dni = ((String)request.getParameter("dni"));
														ClienteDTO cliente = BusinessDelegate.getInstancia().buscarClienteByDni(dni);
														session.setAttribute("cliente", cliente);
														if (cliente != null) {
															dispatcher=request.getRequestDispatcher("/verCarrito.jsp");
															dispatcher.forward(request, response);	
														}else {
															request.setAttribute("error", "No se ha encontrado el cliente");
															dispatcher=request.getRequestDispatcher("/verCarrito.jsp");
															dispatcher.forward(request, response);	
														}
													
													}catch (Exception e) {
														e.printStackTrace();
														
													}
												}else {
													if(request.getParameter("action").equalsIgnoreCase("ingresoMedioPago")) {
														RequestDispatcher dispatcher;
														try {
															String medioPago = ((String)request.getParameter("medioPago"));
															if (medioPago.equals("cheque")) {
																dispatcher=request.getRequestDispatcher("/ingresoCheque.jsp");
																dispatcher.forward(request, response);	
															}
														}catch (Exception e) {
															e.printStackTrace();
															
														}
													}else {
														if(request.getParameter("action").equalsIgnoreCase("procesarVenta")) {
															RequestDispatcher dispatcher;
															try {
																String medioPago = ((String)request.getParameter("medioPago"));
																if (medioPago.equals("cheque")){
																	ChequeDTO cheque = new ChequeDTO();
																	ClienteDTO cliente = ((ClienteDTO)session.getAttribute("vencimiento"));
																	List<ArticuloDTO> carrito = ((List<ArticuloDTO>)session.getAttribute("carrito"));
																	ItemVentaDTO item = null;
																	for(ArticuloDTO articulo : carrito) {
																		item = new ItemVentaDTO();
																		item.setArticulo(articulo);
																		item.setCantidad(1);
																		cheque.getItems().add(item);
																	}
																	session.setAttribute("cliente", cliente);
																	String titular = ((String)request.getParameter("titular"));
																	String banco = ((String)request.getParameter("banco"));
																	String numero = ((String)request.getParameter("numero"));
																	String vencimiento = ((String)request.getParameter("vencimiento"));
																	cheque.setTitular(titular);
																	cheque.setNumeroCheque(numero);
																	cheque.setVencimiento(vencimiento);
																	cheque.setBanco(banco);
																	cheque.setCliente(cliente);
																	cheque.setEntregaInmediata(true);
																	cheque.setEstado("Confirmada");
																	Date fecha = new Date();
																	cheque.setFecha(fecha);
																	
																	dispatcher=request.getRequestDispatcher("/ingresoCheque.jsp");
																	dispatcher.forward(request, response);	
																}
																
															}catch (Exception e) {
																e.printStackTrace();
																
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			doPost(req, resp);
		}
}
