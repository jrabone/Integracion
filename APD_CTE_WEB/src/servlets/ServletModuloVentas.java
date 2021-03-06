package servlets;
import java.io.IOException;
import java.util.ArrayList;
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
