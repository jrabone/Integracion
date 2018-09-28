<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>iaPOS!</title>

    <!-- Bootstrap core CSS -->
    <link href="http://localhost:8180/APD_CTE_WEB/vendor2/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style>
      body {
        padding-top: 54px;
      }
      @media (min-width: 992px) {
        body {
          padding-top: 56px;
        }
      }

    </style>

  </head>

  <body>
  
  <%
				if (request.getAttribute("error") != null) {
			%>
			<div class="col-md-12">
				<div class="alert alert-danger">
					<p><%=request.getAttribute("error")%></p>
				</div>
			</div>
			<%
				}
			%>
			<%
				if (request.getAttribute("mensaje") != null) {
			%>
			<div class="col-md-12">
				<div class="alert alert-info">
					<p><%=request.getAttribute("mensaje")%></p>
				</div>
			</div>
			<%
				}
			%>
  
  	     	
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="http://localhost:8180/APD_CTE_WEB/logochico.png" 
     srcset = "http://localhost:8180/APD_CTE_WEB/logochico.png 2x, 
             http://localhost:8180/APD_CTE_WEB/logochico.png 768w, 
             http://localhost:8180/APD_CTE_WEB/logochico.png 768w 2x, 
             http://localhost:8180/APD_CTE_WEB/logochico.png 1200w, 
             http://localhost:8180/APD_CTE_WEB/logochico.png 1200w 2x" /></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Inicio
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Login</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h1 class="mt-5">Acceso vendedores</h1>
          <p class="lead">Ingresa tus datos de registro para acceder al portal</p>
          <ul class="list-unstyled">
          <form action="http://localhost:8180/APD_CTE_WEB/servlets/ServletModuloVentas" method="post" id="loginUsuarios">
            <table class="table table-bordered" cellspacing="0" witdh=50%>
            
            <tr>
            <td>
            Email:
            </td>
            <td>
            <input class="form-control" id="email" name="email" type="text">
            </td>
            <tr>
            <td>
            Password:
            </td>
            <td>
            <input class="form-control" id="password" name="password" type="password">
            </td>
            </tr>
            
            <tr>
            <td>
            
            </td>
            
            <td>
            <input type="hidden" name="action" value="loginUsuarios">
            <input type="submit" class="btn btn-primary" align=center name="loginUsuarios" value="Ingresar">
            </td>
            </tr>
            </table>
            </form>

          </ul>
        </div>
      </div>
    </div>

 
    <!-- Bootstrap core JavaScript -->
    <script src="http://localhost:8180/APD_CTE_WEB/vendor/jquery/jquery.min.js"></script>
    <script src="http://localhost:8180/APD_CTE_WEB/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
