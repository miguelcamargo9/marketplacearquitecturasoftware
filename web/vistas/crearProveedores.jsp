<%-- 
    Document   : registrarseVista
    Created on : 06-mar-2014, 23:50:20
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String mensaje = "";
  mensaje = (String) session.getAttribute("mensaje");
  mensaje = mensaje == null ? "" : mensaje;
  String error = "";
  error = (String) session.getAttribute("error");
  error = error == null ? "" : error;
%>
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
    <!--<div class="container-fluid">-->   
    <div class="col-sm-6">
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">
            Registrar Proveedor
          </h3>
        </div>
        <div class="panel-body">
          <form action="../proveedorServlet" method="post" class="form-horizontal" role="form">
            <div class="form-group">
              <input type="text" name="nitProveedor" placeholder="Nit Proveedor" class="form-control" required>
            </div>
            <div class="form-group">
              <input type="text" name="nickname" placeholder="Nickname" class="form-control" required>
            </div>
            <div class="form-group">
              <input type="text" name="razonSocial" placeholder="Razon Social" class="form-control" required>
            </div>
            <div class="form-group">
              Nombre Comercial:
              <select name="tipoEmpresa">
                <option selected>
                  SAS
                </option>
                <option>
                  LTDA
                </option>
                <option>
                  SA
                </option>
                <option>
                  INC
                </option>
              </select>
            </div>
            <div class="form-group">
              <input type="password" name="password" placeholder="Password" class="form-control" required>
            </div>
            <div class="form-group">
              <input type="password" name="passwordC" placeholder="Confirme Password" class="form-control" required>
            </div>
            <div class="form-group">
              <input type="email" name="correo" placeholder="Correo Electronico" class="form-control" required>
            </div>
            <center>
              <input type="submit" class="btn btn-lg btn-info" value="Continuar">
            </center>
          </form>
        </div>
      </div>
      <% if (!mensaje.equals("")) {
      %>
      <div class="alert alert-success">
        <strong>
          <%=mensaje%>
        </strong>
      </div>
      <%
        }
        if (!error.equals("")) {
      %>
      <div class="alert alert-danger">
        <strong>
          <%=error%>
        </strong>
      </div>
      <%
        }
        session.removeAttribute("error");
        session.removeAttribute("mensaje");
      %>
    </div>
    <!--      <div class="footer">
            desarrollado por:
            Sebastian Rojas
            Miguel Camargo
          </div>-->
    <!--</div>-->
  </body>
</html>