package servlets;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delegado.BusinessDelegate;
import dto.VendedorDTO;

public class ServletModuloVentas {
	private static final long serialVersionUID = -2995544905709948607L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			HttpSession session = request.getSession();
			
			if(request.getParameter("action").equalsIgnoreCase("loginUsuarios")){
				RequestDispatcher dispatcher;
	    		VendedorDTO usuario = null;
	    		String email = ((String)request.getParameter("email"));
	    		String password = ((String)request.getParameter("password"));
	    		try {
					usuario = BusinessDelegate.getInstancia().loginUsuario(email, password);
					if(usuario != null) {

					}else {
						
						request.setAttribute("error", "Usuario o password invalido");
						
						dispatcher=request.getRequestDispatcher("/login.jsp");
			    		dispatcher.forward(request, response);
						
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			doPost(req, resp);
		}
}
