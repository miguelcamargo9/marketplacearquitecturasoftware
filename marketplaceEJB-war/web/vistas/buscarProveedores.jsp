<%-- 
    Document   : buscarProveedores
    Created on : 24/04/2014, 10:56:02 AM
    Author     : Lina Paola
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
    <title>Formulario de Consulta</title>
  </head>
  <body>
    <!--<div class="container-fluid">-->   
    <div class="col-sm-6">
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">
            Consultar Todos los Proveedores
          </h3>
        </div>
        <div class="panel-body">
          <form action="../busquedaProveedorServlet" method="post" class="form-horizontal" role="form">
            <div class="form-group">
            <center>
              <input type="submit" class="btn btn-lg btn-info" value="Ver">
            </center>
            </div>            
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
            Lina Paola Torres
          </div>-->
    <!--</div>-->
  </body>
</html>
