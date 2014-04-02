<%-- 
    Document   : asociarArchivosAdjuntos
    Created on : 9/03/2014, 12:15:40 AM
    Author     : Sebastian Rojas
--%>

<%@page import="com.marketPlace.modelo.archivosAdjuntosModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String listaAdjuntos = null;
  String listaArchivos = null;
  archivosAdjuntosModelo model = new archivosAdjuntosModelo();
  model.crearListaTodosLosAdjuntos();
  model.crearListaTodosLosArchivos();
  listaAdjuntos = model.getListaSeleccionAdjuntos();
  listaArchivos = model.getListaSeleccionArchivos();
  String exito = "";
  String error = "";
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
    <title>Asociar Adjuntos con Archivos</title>
  </head>
  <body>
    <form class="form-horizontal" action="../adjuntosArchivosServlet" method="post">  
      <fieldset>  
        <legend>Asociar Adjuntos con Archivos</legend>
        <table class="table table-hover">
          <tr>
            <td width="10%">Adjunto: </td>
            <td width="90%">
              <%=listaAdjuntos%>
            </td>
          </tr>
          <tr>
            <td width="10%">Archivo: </td>
            <td width="90%">
              <%=listaArchivos%>
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
