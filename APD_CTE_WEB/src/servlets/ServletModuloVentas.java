package servlets;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
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

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.mercadopago.MP;

import delegado.BusinessDelegate;
import dto.ArticuloDTO;
import dto.ChequeDTO;
import dto.ClienteDTO;
import dto.DomicilioDTO;
import dto.EfectivoDTO;
import dto.ItemVentaDTO;
import dto.TarjetaCreditoDTO;
import dto.VendedorDTO;
import dto.VentaDTO;
import sun.misc.IOUtils;



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
						
						List<ArticuloDTO> articulos =  new ArrayList<ArticuloDTO>();//BusinessDelegate.getInstancia().listarArticulos();//new ArrayList<ArticuloDTO>();
						//request.setAttribute("articulos", articulos);
						List<ArticuloDTO> carrito = new ArrayList<ArticuloDTO>();
						//session.setAttribute("articulos",  articulos);
						session.setAttribute("carrito", carrito);
						session.setAttribute("vendedor", usuario);
						
						String urlString = "http://192.168.137.1:8080/productos";
						
						
						StringBuilder result = new StringBuilder();
					      URL url = new URL(urlString);
					      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					      conn.setRequestMethod("GET");
					      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					      String line;
					      while ((line = rd.readLine()) != null) {
					         result.append(line);
					      }
					      rd.close();
					      System.out.println(result);
					      
					      //JSONObject obj = new JSONObject(result.toString());

					      JSONArray items = new JSONArray(result.toString());
					      //JSONArray items = obj.getJSONArray("items");

					      for (int i = 0; i < items.length(); i++)
					      {
					    	  ArticuloDTO art = new ArticuloDTO();
					    	  art.setDescripcion(items.getJSONObject(i).getString("descripcion"));
					    	  art.setFoto(items.getJSONObject(i).getString("fotoUrl"));
					    	  art.setIdArticulo(items.getJSONObject(i).getInt("idProducto"));
					    	  art.setPrecioUnitario(items.getJSONObject(i).getDouble("precioVenta"));
					    	  art.setStock(items.getJSONObject(i).getInt("stockActual"));
					          articulos.add(art);
					      }
					    request.setAttribute("articulos", articulos);
					    session.setAttribute("articulos",  articulos);
					    
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
						articulo.setFoto(request.getParameter("foto"));
						articulo.setStock(Integer.parseInt(request.getParameter("stock")));
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
									session.setAttribute("cliente", null);
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
															else if(medioPago.equals("mercadopago")) {
																String urlBoton = BusinessDelegate.getInstancia().crearboton((List<ArticuloDTO>)session.getAttribute("carrito"));
																request.setAttribute("mercadoPagoUrl", urlBoton);
																session.setAttribute("mercadoPagoUrl", urlBoton);
																dispatcher=request.getRequestDispatcher("/mercadopago.jsp");
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
																	ClienteDTO cliente = ((ClienteDTO)session.getAttribute("cliente"));
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
																	
																	int nroPedido = BusinessDelegate.getInstancia().procesarVenta(cheque);
																}else {
																	if (medioPago.equals("tarjeta")) {
																		TarjetaCreditoDTO tarjeta = new TarjetaCreditoDTO();
																		ClienteDTO cliente = ((ClienteDTO)session.getAttribute("cliente"));
																		List<ArticuloDTO> carrito = ((List<ArticuloDTO>)session.getAttribute("carrito"));
																		ItemVentaDTO item = null;
																		for(ArticuloDTO articulo : carrito) {
																			item = new ItemVentaDTO();
																			item.setArticulo(articulo);
																			item.setCantidad(1);
															
																			tarjeta.getItems().add(item);
																		}
																		tarjeta.setCliente(cliente);
																		tarjeta.setEntregaInmediata(true);
																		tarjeta.setEstado("Confirmada");
																		Date fecha = new Date();
																		tarjeta.setFecha(fecha);
																		
																		
																		int nroPedido = BusinessDelegate.getInstancia().procesarVenta(tarjeta);
																	}else {
																		if (medioPago.equals("efectivo")) {
																			EfectivoDTO efectivo = new EfectivoDTO();
																			ClienteDTO cliente = ((ClienteDTO)session.getAttribute("cliente"));
																			List<ArticuloDTO> carrito = ((List<ArticuloDTO>)session.getAttribute("carrito"));
																			ItemVentaDTO item = null;
																			for(ArticuloDTO articulo : carrito) {
																				item = new ItemVentaDTO();
																				item.setArticulo(articulo);
																				item.setCantidad(1);
																
																				efectivo.getItems().add(item);
																			}
																			efectivo.setCliente(cliente);
																			efectivo.setEntregaInmediata(true);
																			efectivo.setEstado("Confirmada");
																			Date fecha = new Date();
																			efectivo.setFecha(fecha);
																			
																			int nroPedido = BusinessDelegate.getInstancia().procesarVenta(efectivo);
																		}
																	} 
																}
																	//VentaDTO venta = BusinessDelegate.getInstancia().buscarVenta(nroPedido);
																	
																	//request.setAttribute("venta", venta);
																	
																	//dispatcher=request.getRequestDispatcher("/detallePedido.jsp");
																	//dispatcher.forward(request, response);	
																	List<ArticuloDTO> articulos = BusinessDelegate.getInstancia().listarArticulos();
																	request.setAttribute("articulos", articulos);
																	List<ArticuloDTO> carrito = new ArrayList<ArticuloDTO>();
																	session.setAttribute("articulos",  articulos);
																	session.setAttribute("carrito", carrito);
																	
																	request.setAttribute("mensaje", "¡Venta confirmada!");
																	dispatcher=request.getRequestDispatcher("/main.jsp");
																	dispatcher.forward(request, response);	
																
																
															}catch (Exception e) {
																e.printStackTrace();
															}
															}else {
																if(request.getParameter("action").equalsIgnoreCase("detalleVenta")) {
																	RequestDispatcher dispatcher;
																	try {
																		int idVenta = Integer.parseInt(request.getParameter("idVenta"));
																		VentaDTO venta = BusinessDelegate.getInstancia().buscarVenta(idVenta);
																		request.setAttribute("venta", venta);
																		
																		dispatcher=request.getRequestDispatcher("/detallePedido.jsp");
																		dispatcher.forward(request, response);	
																		
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
		}
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			doPost(req, resp);
		}
}
