<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mercadopago.MP"%> 
<%@page import="org.codehaus.jettison.json.JSONObject"%>

<%
	MP mp = new MP("6103576789455888", "J3MAUDGrW9MB5FLIS20Xos44uQycaO7f");

	String preferenceData = "{'items':"+
		"[{"+
			"'title':'Multicolor kite',"+
			"'quantity':1,"+
			"'currency_id':'ARS',"+ // Available currencies at: https://api.mercadopago.com/currencies
			"'unit_price':10.0"+
		"}]"+
	"}";

	JSONObject preference = mp.createPreference(preferenceData);

	String initPoint = preference.getJSONObject("response").getString("init_point");
%>
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
        <a class="navbar-brand" href="#"><img src="/APD_CTE_WEB/logochico.png" 
     srcset = "/APD_CTE_WEB/logochico.png 2x, 
             /APD_CTE_WEB/logochico.png 768w, 
             /APD_CTE_WEB/logochico.png 768w 2x, 
             /APD_CTE_WEB/logochico.png 1200w, 
             /APD_CTE_WEB/logochico.png 1200w 2x" /></a>
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
          <form action="/APD_CTE_WEB/servlets/ServletModuloVentas" method="post" id="loginUsuarios">
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
            <a href="<%= initPoint %>">Pay</a>
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
    <script src="/APD_CTE_WEB/vendor/jquery/jquery.min.js"></script>
    <script src="/APD_CTE_WEB/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
