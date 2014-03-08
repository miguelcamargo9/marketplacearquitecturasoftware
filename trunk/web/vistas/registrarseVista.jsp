<%-- 
    Document   : registrarseVista
    Created on : 06-mar-2014, 23:50:20
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
    <title>Formulario de Registro</title>
  </head>
  <body>
    <div class="container-fluid">   
      <div class="navbar">
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">MarketPlace</a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">
              Registrar Usuario
            </h3>
          </div>
          <div class="panel-body">
            <form action="../registroServlet" method="post" class="navbar-form navbar-right" role="form">
              <div class="form-group">
                <input type="text" name="idUsuario" placeholder="Cedula" class="form-control">
                <input type="text" name="nickname" placeholder="Nickname" class="form-control">
              </div>
              <div class="form-group">
                <input type="text" name="primerNombre" placeholder="Primer Nombre" class="form-control">
                <input type="text" name="segundoNombre" placeholder="Segundo Nombre" class="form-control">
              </div>
              <div class="form-group">
                <input type="text" name="primerApellido" placeholder="Primer Apellido" class="form-control">
                <input type="text" name="segundoApellido" placeholder="Segundo Apellido" class="form-control">
              </div>
              <div class="form-group">
                <input type="password" name="password" placeholder="Password" class="form-control">
                <input type="password" name="passwordC" placeholder="Confirme Password" class="form-control">
              </div>
              <div class="form-group">
                <input type="text" name="correo" placeholder="Correo Electronico" class="form-control">
              </div>
              <div class="form-group">
                <input type="submit" class="btn btn-lg btn-info" value="Continuar">
                <button class="btn btn-lg btn-danger" type="button" >Cancelar</button>
              </div>
            </form>
          </div>
        </div>
      </div>
<!--      <div class="footer">
        desarrollado por:
        Sebastian Rojas
        Miguel Camargo
      </div>-->
    </div>
  </body>
</html>
