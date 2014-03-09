<%-- 
    Document   : creacionAdjuntos
    Created on : 8/03/2014, 05:18:54 PM
    Author     : Sebastian Rojas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String exito = "";
  String error = "";
  exito = (String) session.getAttribute("exito");
  error = (String) session.getAttribute("error");
  exito = exito == null ? "": exito;
  error = error == null ? "": error;
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
    <title>Creacion de Adjuntos</title>
  </head>
  <body>
    <form class="form-horizontal" action="../adjuntoServlet" method="post">  
      <fieldset>  
        <legend>Creacion de Adjuntos</legend>
        <table class="table table-hover">
          <tr>
            <td width="10%">Descripcion: </td>
            <td width="90%">
              <input type="text" class="form-control" name="descripcion" placeholder="Descripcion...">
            </td>
          </tr>
        </table>
        <input type="submit" value="enviar" class="btn btn-primary">
      </fieldset>  
    </form>
    <% if(!exito.equals("")){
      %>
      <div class="alert alert-success">
        <strong>
          <%=exito%>
        </strong>
      </div>
      <%
      } %>
    <% 
    if(!error.equals("")){
      %>
      <div class="alert alert-warning">
        <strong>
          <%=error%>
        </strong>
      </div>
      <%
      } %>
  </body>
</html>
