/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-09-27 20:39:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.ArticuloDTO;
import dto.VendedorDTO;
import java.util.List;
import java.util.Iterator;

public final class verCarrito_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Iterator");
    _jspx_imports_classes.add("dto.ArticuloDTO");
    _jspx_imports_classes.add("dto.VendedorDTO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("  <head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>iaPOS!</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core CSS -->\n");
      out.write("    <link href=\"http://localhost:8180/APD_CTE_WEB/vendor2/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom styles for this template -->\n");
      out.write("    <link href=\"http://localhost:8180/APD_CTE_WEB/css/3-col-portfolio.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("<!-- Navigation -->\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark fixed-top\">\n");
      out.write("      <div class=\"container-fluid\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\"><img src=\"http://localhost:8180/APD_CTE_WEB/logochico.png\" \n");
      out.write("     srcset = \"http://localhost:8180/APD_CTE_WEB/logochico.png 2x, \n");
      out.write("             http://localhost:8180/APD_CTE_WEB/logochico.png 768w, \n");
      out.write("             http://localhost:8180/APD_CTE_WEB/logochico.png 768w 2x, \n");
      out.write("             http://localhost:8180/APD_CTE_WEB/logochico.png 1200w, \n");
      out.write("             http://localhost:8180/APD_CTE_WEB/logochico.png 1200w 2x\" /></a>\n");
      out.write("        <h1 class=\"my-41\">\n");
      out.write("         ");
 VendedorDTO vendedor= (VendedorDTO)session.getAttribute("vendedor");
      out.write("\n");
      out.write("         ");
 List<ArticuloDTO> carrito= (List<ArticuloDTO>)session.getAttribute("carrito");
      out.write("\n");
      out.write("         ");
 int cantidad = carrito.size();
      out.write("\n");
      out.write("        <verysmall>Bienvenido, ");
      out.print(vendedor.getNombre() );
      out.write("</verysmall>\n");
      out.write("      </h1>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("          <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n");
      out.write("          <ul class=\"navbar-nav ml-auto\">\n");
      out.write("          <li class=\"nav-item active\">\n");
      out.write("              <a class=\"nav-link\" href=\"ServletModuloVentas?action=verCarrito\">Confirmar Carrito\n");
      out.write("                <span class=\"sr-only\">(current)</span>\n");
      out.write("              </a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link\" href=\"ServletModuloVentas?action=vaciarCarrito\">Vaciar Carrito\n");
      out.write("              </a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link\" href=\"ServletModuloVentas?action=cerrarSesion\">Cerrar sesión</a>\n");
      out.write("            </li>\n");
      out.write("          </ul>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <!-- Page Content -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("      <!-- Page Heading -->\n");
      out.write("      <h1 class=\"my-4\">iaPOS\n");
      out.write("        <small>Carrito del Cliente</small>\n");
      out.write("      </h1>\n");
      out.write("      <div class=\"row\">\n");
      out.write("              <div class=\"card-body\">\n");
      out.write("          <div class=\"table-responsive\">\n");
      out.write("            <table class=\"table table-bordered\" id=\"dataTable\" cellspacing=\"0\">\n");
      out.write("              <thead>\n");
      out.write("                <tr>\n");
      out.write("                  <th>Articulo</th>\n");
      out.write("                  <th>Descripcion</th>\n");
      out.write("                  <th>Precio Unitario</th>\n");
      out.write("                  <th>Cantidad</th>\n");
      out.write("                </tr>\n");
      out.write("              </thead>\n");
      out.write("              <tbody>\n");
      out.write("              ");

            	  ArticuloDTO articulo = null;
  				  double total = 0;
  				  int cant = 0;
				if (carrito != null) {
					for (Iterator<ArticuloDTO> i = carrito.iterator(); i.hasNext();) {
						articulo = i.next();
						total += articulo.getPrecioUnitario();
						cant += 1;
				
      out.write("\n");
      out.write("              <tr>\n");
      out.write("                  <td>");
      out.print(articulo.getIdArticulo() );
      out.write("</td>\n");
      out.write("                  <td>");
      out.print(articulo.getDescripcion() );
      out.write("</td>\n");
      out.write("                  <td>");
      out.print(articulo.getDescripcion() );
      out.write("</td>\n");
      out.write("                  <td>1</td>\n");
      out.write("                  <td><table class=\"table table-bordered\">\n");
      out.write("\t\t\t\t  \n");
      out.write("\t\t\t\t  <th>\n");
      out.write("              <a class=\"nav-link\" href=\"ServletModuloVentas?action=verCarrito\">Eliminar\n");
      out.write("              </a>\n");
      out.write("            </th>\n");
      out.write("\t\t\t\t  </th></table></td>\n");
      out.write("              </tr> \n");
      out.write("              ");
}} 
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("            </table>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- /.row -->\n");
      out.write("      \n");
      out.write("\t\n");
      out.write("\n");
      out.write("      <!-- Page Heading -->\n");
      out.write("      <h4 class=\"my-42\">Cantidad de Artículos:     \n");
      out.write("        ");
      out.print(cant );
      out.write("\n");
      out.write("      </h4>\n");
      out.write("      <h4 class=\"my-42\">Importe total:     \n");
      out.write("        $");
      out.print(total );
      out.write("\n");
      out.write("      </h4> \n");
      out.write("       \n");
      out.write("      \n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /.container -->\n");
      out.write("\n");
      out.write("    <!-- Footer -->\n");
      out.write("    <footer class=\"py-5 bg-dark\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <p class=\"m-0 text-center text-white\"></p>\n");
      out.write("      </div>\n");
      out.write("      <!-- /.container -->\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core JavaScript -->\n");
      out.write("    <script src=\"http://localhost:8180/APD_CTE_WEB/vendor/jquery/jquery.min.js\"></script>\n");
      out.write("    <script src=\"http://localhost:8180/APD_CTE_WEB/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
