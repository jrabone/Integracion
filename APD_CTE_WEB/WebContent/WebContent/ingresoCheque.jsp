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
    <link href="http://localhost:8090/APD_CTE_WEB/vendor2/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://localhost:8090/APD_CTE_WEB/css/3-col-portfolio.css" rel="stylesheet">

  </head>

  <body>

<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="http://localhost:8090/APD_CTE_WEB/logochico.png" 
     srcset = "http://localhost:8090/APD_CTE_WEB/logochico.png 2x, 
             http://localhost:8090/APD_CTE_WEB/logochico.png 768w, 
             http://localhost:8090/APD_CTE_WEB/logochico.png 768w 2x, 
             http://localhost:8090/APD_CTE_WEB/logochico.png 1200w, 
             http://localhost:8090/APD_CTE_WEB/logochico.png 1200w 2x" /></a>
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
        <small>Pago | Ingreso de cheque</small>
      </h1>
      
            <form action="/APD_CTE_WEB/servlets/ServletModuloVentas" method="post" id="procesarVentaCheque">
            <table class="table table-bordered" cellspacing="0" witdh=50%>
            
            <tr>
            <td>
            Titular:
            </td>
            <td>
            <input class="form-control" id="titular" name="titular" type="text">
            </td>
            </tr>
            <tr>
            <td>
            Banco:
            </td>
            <td>
            <input class="form-control" id="banco" name="banco" type="text">
            </td>
            </tr>
            <tr>
            <td>
            Numero:
            </td>
            <td>
            <input class="form-control" id="numero" name="numero" type="text">
            </td>
            </tr>
            
            <tr>
            <td>
            Vencimiento:
            </td>
            <td>
            <input class="form-control" id="vencimiento" name="vencimiento" type="date">
            </td>
            </tr>
            </table>
            
             <table class="table table-bordered" cellspacing="0" witdh=50%>
            <tr>
            <td>
            <input type="hidden" name="action" value="procesarVentaCheque">
            <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#exampleModal">Cambiar medio de pago</a>

            <input type="submit" class="btn btn-primary" align=center name="procesarVentaCheque" value="Confirmar">
            </td>
            </tr> 
            
            </table>
            </form>
  
      <!-- /.row -->

      <!-- Pagination -->


    </div>
    <!-- /.container -->
    
      <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Confirmación de compra</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Seleccione el medio de pago</div>

          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <a class="btn btn-primary" href="ServletModuloVentas?action=ingresoMedioPago&medioPago=mercadopago">Mercado Pago</a>
            <a class="btn btn-primary" href="ServletModuloVentas?action=ingresoMedioPago&medioPago=efectivo">Efectivo</a>
            <a class="btn btn-primary" href="ServletModuloVentas?action=ingresoMedioPago&medioPago=cheque">Cheque</a>
            <a class="btn btn-primary" href="ServletModuloVentas?action=ingresoMedioPago&medioPago=tarjeta">Tarjeta</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white"></p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="http://localhost:8090/APD_CTE_WEB/vendor/jquery/jquery.min.js"></script>
    <script src="http://localhost:8090/APD_CTE_WEB/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body> 

</html>
