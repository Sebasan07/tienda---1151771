<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Nuestra tienda virtual</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="css/registro.css">
</head>
<body>
<div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto">
              <h3 class="login-heading mb-4">Registro de Tienda</h3>
              <form action="${pageContext.request.contextPath}/TiendaServlet?action=register" method="post">
                <div class="form-label-group">
                  <input type="text" id="inputNombre" class="form-control" placeholder="Nombre" name="nombre"required autofocus>
                  <label for="inputNombre">Nombre</label>
                </div>
                <div class="form-label-group">
                  <input type="text" id="inputLema" class="form-control" placeholder="Lema" name="lema" required autofocus>
                  <label for="inputLema">Lema</label>
                </div>
                <div class="form-label-group">
                  <textarea id="inputDescripcion" class="form-control" placeholder="Descripcion" name="descripcion" required autofocus></textarea>
                  <label for="inputDescripcion">Descripción</label>
                </div>
                <div class="form-label-group">
                  <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required autofocus>
                  <label for="inputEmail">Email</label>
                </div>

                <div class="form-label-group">
                  <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="pass" required>
                  <label for="inputPassword">Password</label>
                </div>

                <div class="form-label-group">
                  <input type="input" id="inputPropietario" class="form-control" placeholder="Propietario" name="propietario" required>
                  <label for="inputPropietario">Propietario</label>
                </div>
                <div class="form-label-group">
                  <input type="input" id="inputFacebook" class="form-control" placeholder="Facebook" name="facebook" required>
                  <label for="inputFacebook">Facebook</label>
                </div>
                <div class="form-label-group">
                  <input type="input" id="inputWeb" class="form-control" placeholder="Web" name="web" required>
                  <label for="inputWeb">Web</label>
                </div>
                <div class="form-label-group">
                  <input type="input" id="inputImagen" class="form-control" placeholder="Imagen" name="img" required>
                  <label for="inputImagen">Imagen</label>
                </div>


                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Registrar</button>

              </form>
              
               <% 
            if(request.getAttribute("mensaje")!=null) 
            { 
        %>          
                <script>alert( ""+<%=request.getAttribute("mensaje")%>)</script>
        <%
            }
                %>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>