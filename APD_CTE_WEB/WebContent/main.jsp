<%@ page import="dto.ArticuloDTO"%>
<%@ page import="dto.VendedorDTO"%>
<%@ page import="java.util.List"%>

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
              <a class="nav-link" href="ServletModuloVentas?action=verCarrito">Ver carrito (<%=cantidad%>)
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ServletModuloVentas?action=cerrarSesion">Cerrar sesión</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading -->
      <h1 class="my-4">iaPOS
        <small>Artículos destacados</small>
      </h1>
      <div class="row">
      <% List<ArticuloDTO> articulos = (List<ArticuloDTO>)request.getAttribute("articulos");
	 for(ArticuloDTO articulo : articulos){
	 %>
	        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"><img class="card-img-top" src="<%=articulo.getFoto() %>" alt=""></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="ServletModuloVentas?action=agregarArticuloCarrito&idArticulo=<%=articulo.getIdArticulo().toString()%>">Agregar</a>
              </h4>
              <p class="card-text">   <%=articulo.getDescripcion() %> 
              	<h4 class="card-title">$<%=articulo.getPrecioUnitario() %></h4>
              	<h4 class="card-title">Stock: <%=articulo.getStock() %> </h4> 
              </p>         
            </div>
          </div>
        </div>
	 <% } %>
      </div>
      <!-- /.row -->

      <!-- Pagination -->
      <ul class="pagination justify-content-center">
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
            <span class="sr-only">Previous</span>
          </a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">1</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">2</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">3</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
          </a>
        </li>
      </ul>

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
