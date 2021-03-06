<%@ page import="dto.ArticuloDTO"%>
<%@ page import="dto.VendedorDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>iaPOS!</title>

    <!-- Bootstrap core CSS -->
    <link href="/APD_CTE_WEB/vendor2/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/APD_CTE_WEB/css/3-col-portfolio.css" rel="stylesheet">

  </head>

  <body>

<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="/APD_CTE_WEB/logochico.png" 
     srcset = "/APD_CTE_WEB/logochico.png 2x, 
             /APD_CTE_WEB/logochico.png 768w, 
             /APD_CTE_WEB/logochico.png 768w 2x, 
             /APD_CTE_WEB/logochico.png 1200w, 
             /APD_CTE_WEB/logochico.png 1200w 2x" /></a>
        <h1 class="my-41">
         <% VendedorDTO vendedor= (VendedorDTO)session.getAttribute("vendedor");%>
         <% List<ArticuloDTO> carrito= (List<ArticuloDTO>)session.getAttribute("carrito");%>
         <% int cantidad = carrito.size();%>
        <verysmall>Bienvenido, <%=vendedor.getNombre() %></verysmall>
      </h1>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
              <a class="nav-link" href="ServletModuloVentas?action=verCarrito">Confirmar Carrito
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ServletModuloVentas?action=vaciarCarrito">Vaciar Carrito
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ServletModuloVentas?action=cerrarSesion">Cerrar sesi�n</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading -->
      <h1 class="my-4">iaPOS
        <small>Carrito del Cliente</small>
      </h1>
      <div class="row">
              <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" cellspacing="0">
              <thead>
                <tr>
                  <th>Articulo</th>
                  <th>Descripcion</th>
                  <th>Precio Unitario</th>
                  <th>Cantidad</th>
                </tr>
              </thead>
              <tbody>
              <%
            	  ArticuloDTO articulo = null;
  				  double total = 0;
  				  int cant = 0;
				if (carrito != null) {
					for (Iterator<ArticuloDTO> i = carrito.iterator(); i.hasNext();) {
						articulo = i.next();
						total += articulo.getPrecioUnitario();
						cant += 1;
				%>
              <tr>
                  <td><%=articulo.getIdArticulo().toString() %></td>
                  <td><%=articulo.getDescripcion() %></td>
                  <td><%=String.valueOf(articulo.getPrecioUnitario()) %></td>
                  <td>1</td>
                  <td><table class="table table-bordered">
				  
				  <th>
              <a class="nav-link" href="ServletModuloVentas?action=eliminarDelCarrito&idArticulo=<%=articulo.getIdArticulo().toString()%>">Eliminar
              </a>
            </th>
				  </th></table></td>
              </tr> 
              <%}} %>
                            </tbody>
            </table>
          </div>
        </div>
      </div>
      <!-- /.row -->
      
	

      <!-- Page Heading -->
      <h4 class="my-42">Cantidad de Art�culos:     
        <%=cant %>
      </h4>
      <h4 class="my-42">Importe total:     
        $<%=total %>
      </h4> 
       
      


    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white"></p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="/APD_CTE_WEB/vendor/jquery/jquery.min.js"></script>
    <script src="/APD_CTE_WEB/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
