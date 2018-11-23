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
        <small>Alta de cliente</small>
      </h1>
      
            <form action="/APD_CTE_WEB/servlets/ServletModuloVentas" method="post" id="procesarAltaCliente">
            <table class="table table-bordered" cellspacing="0" witdh=50%>
            
            <tr>
            <td>
            <b>Datos generales:</b>
            </td>
            <tr>
            <td>
            Nombre:
            </td>
            <td>
            <input class="form-control" id="nombre" name="nombre" type="text">
            </td>
            <tr>
            <td>
            Apellido:
            </td>
            <td>
            <input class="form-control" id="apellido" name="apellido" type="text">
            </td>
            </tr>
            <tr>
            <td>
            DNI:
            </td>
            <td>
            <input class="form-control" id="dni" name="dni" type="text">
            </td>
            <tr>
            <tr>
            <td>
            Teléfono:
            </td>
            <td>
            <input class="form-control" id="telefono" name="telefono" type="number">
            </td>
            <tr>
            <tr>
            <td>
            Celular:
            </td>
            <td>
            <input class="form-control" id="celular" name="celular" type="number">
            </td>
            <tr>

            <tr>
            <td>
            <b>Domicilio Facturación</b>
            </td>

            <tr>
            <td>
            Calle:
            </td>
            <td>
            <input class="form-control" id="FacturacionCalle" name="FacturacionCalle" type="text">
            </td>
            </tr>
            <tr>
            <td>
            Numero:
            </td>
            <td>
            <input class="form-control" id="FacturacionNumero" name="FacturacionNumero" type="number">
            </td>
            </tr>
            
            <tr>
            <td>
            Piso:
            </td>
            <td>
            <input class="form-control" id="FacturacionPiso" name="FacturacionPiso" type="text">
            </td>
            </tr>
            
            <tr>
            <td>
            Departamento:
            </td>
            <td>
            <input class="form-control" id="FacturacionDpto" name="FacturacionDpto" type="text">
            </td>
            </tr>
            
            <tr>
            <td>
            Localidad:
            </td>
            <td>
            <input class="form-control" id="FacturacionLocalidad" name="FacturacionLocalidad" type="text">
            </td>
            </tr>
            <tr>
            <td>
            Código Postal:
            </td>
            <td>
            <input class="form-control" id="FacturacionCodigoPostal" name="FacturacionCodigoPostal" type="text">
            </td>
            </tr>
            <tr>
            <td>
            Provincia:
            </td>
            <td>
            <select class="form-control" id="FacturacionProvincia" name="FacturacionProvincia" type="text">
            <option value="Ciudad de Buenos Aires">Ciudad de Buenos Aires</option>
            <option value="Buenos Aires">Buenos Aires</option>
            <option value="Catamarca">Catamarca</option>
            <option value="Chaco">Chaco</option>
            <option value="Chubut">Chubut</option>
            </select>
            </td>
            </tr>
            <tr>
            <td>
            País:
            </td>
            <td>
            <select class="form-control" id="FacturacionPais" name="FacturacionPais" type="text">
            <option value="Argentina">Argentina</option>
            </select>
            </td>
            </tr>
            
             <tr>
            <td>
            <b>Domicilio de Entrega</b>
            </td>

            <tr>
            <td>
            Calle:
            </td>
            <td>
            <input class="form-control" id="EntregaCalle" name="EntregaCalle" type="text">
            </td>
            </tr>
            <tr>
            <td>
            Numero:
            </td>
            <td>
            <input class="form-control" id="EntregaNumero" name="EntregaNumero" type="number">
            </td>
            </tr>
            
            <tr>
            <td>
            Piso:
            </td>
            <td>
            <input class="form-control" id="EntregaPiso" name="EntregaPiso" type="text">
            </td>
            </tr>
            
            <tr>
            <td>
            Departamento:
            </td>
            <td>
            <input class="form-control" id="EntregaDpto" name="EntregaDpto" type="text">
            </td>
            </tr>
            
            <tr>
            <td>
            Localidad:
            </td>
            <td>
            <input class="form-control" id="EntregaLocalidad" name="EntregaLocalidad" type="text">
            </td>
            </tr>
            <tr>
            <td>
            Código Postal:
            </td>
            <td>
            <input class="form-control" id="EntregaCodigoPostal" name="EntregaCodigoPostal" type="text">
            </td>
            </tr>
            <tr>
            <td>
            Provincia:
            </td>
            <td>
            <select class="form-control" id="EntregaProvincia" name="EntregaProvincia" type="text">
            <option value="Ciudad de Buenos Aires">Ciudad de Buenos Aires</option>
            <option value="Buenos Aires">Buenos Aires</option>
            <option value="Catamarca">Catamarca</option>
            <option value="Chaco">Chaco</option>
            <option value="Chubut">Chubut</option>
            </select>
            </td>
            </tr>
            <tr>
            <td>
            País:
            </td>
            <td>
            <select class="form-control" id="EntregaPais" name="EntregaPais" type="text">
            <option value="Argentina">Argentina</option>
            </select>
            </td>
            </tr>
            
            
            <tr>
            
            
            <td>
            
            </td>
            
            <td>
            <input type="hidden" name="action" value="procesarAltaCliente">
            <input type="submit" class="btn btn-primary" align=center name="procesarAltaCliente" value="Confirmar">
            </td>
            </tr>
            </table>
            </form>
  
      <!-- /.row -->

      <!-- Pagination -->


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
    <script src="http://localhost:8090/APD_CTE_WEB/vendor/jquery/jquery.min.js"></script>
    <script src="http://localhost:8090/APD_CTE_WEB/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
