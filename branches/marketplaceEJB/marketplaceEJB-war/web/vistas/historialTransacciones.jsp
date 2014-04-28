<%-- 
    Document   : historialTransacciones
    Created on : 28/04/2014, 01:31:41 AM
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
  exito = exito == null ? "": exito;
  error = error == null ? "": error;
  idUsuario = idUsuario == null ? "0": error;
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
    <title>Historial Transacciones</title>
  </head>
  <body>
    <form class="form-horizontal" action="../historialTransaccionesServlet" method="post">  
      <fieldset>  
        <legend>Historial Transacciones</legend>
        <input type="hidden" value="<%=idUsuario%>" name="idUsuario">
        <table class="table table-hover">
          <tr>
           <td width="10%">Fecha Inicial: </td>
            <td width="40%">
              <input type="date" class="form-control" name="fechaInicial">
            </td>
          </tr>
          <tr>
            <td width="10%">Fecha Final: </td>
            <td width="40%">
              <input type="date" class="form-control" name="fechaFinal">
            </td>
          </tr>
        </table>
        <input type="submit" value="Buscar" class="btn btn-primary">
      </fieldset>  
    </form>
  </body>
</html>