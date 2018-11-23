<%@ page import="dto.ArticuloDTO"%>
<%@ page import="dto.VendedorDTO"%>
<%@ page import="dto.ClienteDTO"%>
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
        <a class="navbar-brand" href="ServletModuloVentas?action=listarArticulos"><img src="/APD_CTE_WEB/logochico.png" 
     srcset = "/APD_CTE_WEB/logochico.png 2x, 
             /APD_CTE_WEB/logochico.png 768w, 
             /APD_CTE_WEB/logochico.png 768w 2x, 
             /APD_CTE_WEB/logochico.png 1200w, 
             /APD_CTE_WEB/logochico.png 1200w 2x" /></a>
        <h1 class="my-41">
         <% VendedorDTO vendedor= (VendedorDTO)session.getAttribute("vendedor");%>
         <% List<ArticuloDTO> carrito= (List<ArticuloDTO>)session.getAttribute("carrito");%>
         <% ClienteDTO cliente = (ClienteDTO)session.getAttribute("cliente");%>
         <% int cantidad = carrito.size();%>
        <verysmall>Bienvenido, <%=vendedor.getNombre() %></verysmall>
      </h1>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
              <a class="nav-link" href="#" data-toggle="modal" data-target="#exampleModal">Confirmar Carrito
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ServletModuloVentas?action=vaciarCarrito">Vaciar Carrito
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
        <small>Carrito del Cliente</small>
      </h1>
      <div class="row">
              <div class="card-body">
          <% double total = 0;
			  int cant = 0; if(cantidad > 0) { %>
			  
		 <h1 class="my-4">
		    <small>Cliente</small>
		  </h1>
		  <%if (cliente != null){ %>
			<table class="table table-bordered" cellspacing="0" witdh=50%>
            <tr>
            <td>
            <b>Nombre y Apellido</b>
            </td>
            <td>
            </tr>
            
            <tr>
            <td>
            <%=cliente.getNombre() + " " + cliente.getApellido() %>
            </td>
            </tr>
            
            <tr>
            <td>
            <b>DNI</b>
            </td>
            </tr>
            
            <tr>
            <td>
            <%=cliente.getDni() %>
            </td>
            </tr>


            <tr>
            <td>
            <b>Domicilio Facturación</b>
            </td>
            </tr>

            <tr>
            <td>
            <%=cliente.getDomicilioDeFacturacion().getDomicilioCompleto() %>
            </td>
            </tr>
        
            
             <tr>
            <td>
            <b>Domicilio de Entrega</b>
            </td>
            </tr>

            <tr>
            <td>
            <%=cliente.getDomicilioDeEntrega().getDomicilioCompleto() %>
            </td>
            </tr>
            
             <tr>
            <td>
            <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#asignarCliente">Cambiar cliente</a>
            <a class="btn btn-primary" href="ServletModuloVentas?action=altaCliente">Nuevo cliente</a>
            </td>
            </tr>
            
            </table>
		  <%}else{ %>
		  	<table class="table table-bordered" cellspacing="0" witdh=50%>
            <tr>
            <td>
            <b>Sin cliente asignado</b>
            </td>
            </tr>
             <tr>
            <td>
            <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#asignarCliente">Asignar cliente</a>
            <a class="btn btn-primary" href="ServletModuloVentas?action=altaCliente">Nuevo cliente</a>
             </td>
            </tr>
            
            </table>
            
		  <%} %>
		  </div>
		  <div class="card-body">	  
		  <h1 class="my-4">
		    <small>Detalle</small>
		  </h1>
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
				  <a class="btn btn-primary" href="ServletModuloVentas?action=eliminarDelCarrito&idArticulo=<%=articulo.getIdArticulo().toString()%>">Eliminar</a>
            </th>
				  </th></table></td>
              </tr> 
              <%}} %>
                            </tbody>
            </table>
            <%}else{%>
            	
            	<table class="table table-bordered" cellspacing="0" witdh=50%>
            <tr>
            <td>
            <b>Carrito vacío</b>
            </td>
			</tr>
			</table>
            <%}%>
          </div>
        </div>
      </div>
      <!-- /.row -->
      
	

      <!-- Page Heading -->
      <%if (cantidad > 0){ %>
      <h4 class="my-42">Cantidad de Artículos:     
        <%=cant %>
      </h4>
      <h4 class="my-42">Importe total:     
        $<%=total %>
      </h4> 
      <%} %>
       
      


    </div>
    <!-- /.container -->
    
    <!-- Logout Modal-->
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
    
        <div class="modal fade" id="asignarCliente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Asignación de cliente</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">
          
                    <form action="/APD_CTE_WEB/servlets/ServletModuloVentas" method="post" id="ingresoCliente">
            <table class="table table-bordered" cellspacing="0" witdh=50%>
            
            <tr>
            <td>
            DNI: 
            </td>
            <td>
            <input class="form-control" id="dni" name="dni" type="text">
            </td>

            <tr>
            <td>
            
            </td>
            
            <td>
            <input type="hidden" name="action" value="ingresoCliente">
            <input type="submit" class="btn btn-primary" align=center name="ingresoCliente" value="Confirmar">
            </td>
            </tr>
            </table>
            </form>
            
            </div>

          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
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
    <script src="/APD_CTE_WEB/vendor/jquery/jquery.min.js"></script>
    <script src="/APD_CTE_WEB/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>



  </body>

</html>
