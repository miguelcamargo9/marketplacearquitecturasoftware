<%-- 
    Document   : crearServicios
    Created on : 9/03/2014, 10:12:06 PM
    Author     : Sebastian Rojas
--%>

<%@page import="com.marketPlace.modelo.archivosAdjuntosModelo"%>
<%@page import="com.marketPlace.modelo.serviciosModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String exito = "";
  String error = "";
  String listaCategorias = null;
  String listaAdjuntos = null;
  serviciosModelo modelServicios = new serviciosModelo();
  archivosAdjuntosModelo modelarchivosadjuntos = new archivosAdjuntosModelo();
  modelServicios.crearListaSeleccionCategorias();
  modelarchivosadjuntos.crearListaTodosLosAdjuntos();
  listaCategorias = modelServicios.getListaSelecciondeCategorias();
  listaAdjuntos = modelarchivosadjuntos.getListaSeleccionAdjuntos();
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
    <title>Creacion de Servicios</title>
  </head>
  <body>
    <form class="form-horizontal" action="../adjuntoServlet" method="post">  
      <fieldset>  
        <legend>Creacion de Adjuntos</legend>
        <table class="table table-hover">
          <tr>
            <td width="10%">Categoria: </td>
            <td width="90%">
              <%=listaCategorias%>
            </td>
          </tr>
          <tr>
            <td width="10%">Descripcion: </td>
            <td width="90%">
            <input type="text" class="form-control" name="valor" placeholder="Descripcion...">
            </td>
          <tr>
            <td width="10%">Adjunto: </td>
            <td width="90%">
              <%=listaAdjuntos%>
            </td>
          </tr>
          <tr>
            <td width="10%">valor: </td>
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
