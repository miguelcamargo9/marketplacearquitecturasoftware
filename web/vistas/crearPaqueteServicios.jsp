<%-- 
    Document   : crearPaqueteServicios
    Created on : 10/03/2014, 01:27:16 PM
    Author     : Sebastian Rojas
--%>

<%@page import="com.marketPlace.modelo.paqueteServiciosModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String exito = "";
  String error = "";
  String listaPaquetes = "";
  String listaServicios = "";
  paqueteServiciosModelo model = new paqueteServiciosModelo();
  model.crearListaSeleccionPaquetes();
  model.crearListaSeleccionServicios();
  listaPaquetes = model.getListaSeleccionPaquetes();
  listaServicios = model.getListaSeleccionServicios();
  exito = (String) session.getAttribute("exito");
  error = (String) session.getAttribute("error");
  exito = exito == null ? "": exito;
  error = error == null ? "": error;
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../js/jstree/dist/themes/default/style.min.css">
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
    <title>JSP Page</title>
  </head>
  <body>
    <form class="form-horizontal" action="../paqueteServicioServlet" method="post">  
      <fieldset>  
        <legend>Creacion de Paquetes de Servicios</legend>
        <table class="table table-hover">
          <tr>
            <td width="10%">Paquete: </td>
            <td width="90%">
              <%=listaPaquetes%>
            </td>
          </tr>
          <tr>
            <td width="10%">Servicio: </td>
            <td width="90%">
              <%=listaServicios%>
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
<%
  session.removeAttribute("error");
  session.removeAttribute("exito");
%>
