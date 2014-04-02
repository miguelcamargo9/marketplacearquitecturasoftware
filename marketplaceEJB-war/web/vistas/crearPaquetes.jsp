<%-- 
    Document   : crearPaquetes
    Created on : 10/03/2014, 11:19:02 AM
    Author     : Sebastian Rojas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String exito = "";
  String error = "";
  String idUsuario = "";
  exito = (String) session.getAttribute("exito");
  error = (String) session.getAttribute("error");
  idUsuario = (String) session.getAttribute("idUsuario");
  exito = exito == null ? "" : exito;
  error = error == null ? "" : error;
  idUsuario = idUsuario == null ? "" : idUsuario;
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../js/jstree/dist/themes/default/style.min.css">
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
    <title>JSP Page</title>
  </head>
  <body>
    <form class="form-horizontal" action="../paqueteServlet" method="post">  
      <fieldset>  
        <legend>Creacion de Paquetes</legend>
        <table class="table table-hover">
          <input type="hidden" name="idProveedor" value="<%=idUsuario%>">
          <tr>
            <td width="10%">Descripcion: </td>
            <td width="90%">
              <input type="text" class="form-control" name="descripcion" placeholder="Descripcion...">
            </td>
          </tr>
          <tr>
            <td width="10%">Valor: </td>
            <td width="90%">
              <input type="text" class="form-control" name="valor" placeholder="Valor...">
            </td>
          </tr>
        </table>
        <input type="submit" value="enviar" class="btn btn-primary">
      </fieldset>  
    </form>
    <% if (!exito.equals("")) {
    %>
    <div class="alert alert-success">
      <strong>
        <%=exito%>
      </strong>
    </div>
    <%
      }%>
    <%
      if (!error.equals("")) {
    %>
    <div class="alert alert-warning">
      <strong>
        <%=error%>
      </strong>
    </div>
    <%
      }%>
  </body>
</html>
<%
  session.removeAttribute("error");
  session.removeAttribute("exito");
%>
