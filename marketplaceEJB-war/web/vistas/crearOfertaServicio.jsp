<%-- 
    Document   : crearOfertaServicio
    Created on : 10/03/2014, 03:42:28 PM
    Author     : Sebastian Rojas
--%>

<%@page import="com.marketPlace.modelo.paqueteServiciosModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String exito = "";
  String error = "";
  String listaPaquetes = "";
  paqueteServiciosModelo model = new paqueteServiciosModelo();
  listaPaquetes = model.getListaSeleccionPaquetes();
  model.crearListaSeleccionPaquetes();
  listaPaquetes = model.getListaSeleccionPaquetes();
  exito = (String) session.getAttribute("exito");
  error = (String) session.getAttribute("error");
  exito = exito == null ? "" : exito;
  error = error == null ? "" : error;
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
    <title>Creacion Oferta de Servicio</title>
  </head>
  <body>
    <form class="form-horizontal" action="../ofertaServlet" method="post">  
      <fieldset>  
        <legend>Creacion Oferta de Servicio</legend>
        <table class="table table-hover">
          <tr>
            <td width="10%">Descripcion: </td>
            <td width="90%">
              <input type="text" class="form-control" name="descripcion" placeholder="Descripcion...">
            </td>
          </tr>
          <tr>
            <td width="10%">Paquete: </td>
            <td width="90%">
              <%=listaPaquetes%>
            </td>
          </tr>
          <tr>
            <td width="10%">Fecha Inicial: </td>
            <td width="90%">
              <input type="date" name="fechaInicial">
            </td>
          </tr>
          <tr>
            <td width="10%">Fecha Final: </td>
            <td width="90%">
              <input type="date" name="fechaFinal">
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