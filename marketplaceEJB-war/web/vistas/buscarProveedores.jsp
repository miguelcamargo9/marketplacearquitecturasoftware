<%-- 
    Document   : promociones
    Created on : 20/04/2014, 11:55:26 PM
    Author     : Sebastian Rojas
--%>
<%@page import="com.marketPlace.modelo.ofertasModelo"%>
<%
  String grillaCompras = "";
  String idUsuario = "";
  ofertasModelo model = new ofertasModelo();
  model.setListaInicialOfertas();
  grillaCompras = model.crearGrillaOfertas();
  String exito = "";
  String error = "";
  exito = (String) session.getAttribute("exito");
  error = (String) session.getAttribute("error");
  idUsuario = (String) session.getAttribute("idUsuario");
  exito = exito == null ? "" : exito;
  error = error == null ? "" : error;
  idUsuario = idUsuario == null ? "0" : idUsuario;

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
    <title>MarketPlace</title>
  </head>
  <body>
    <form class="form-horizontal" action="../busquedaProveedorServlet" method="post">
      <fieldset>  
        <legend>Buscar Proveedores</legend>
        <table class="table table-hover">
          <tr>
            <td width="10%">Buscar: </td>
            <td width="90%">
              <input type="text" class="form-control" name="nombre" placeholder="nombre...">
            </td>
          </tr>
        </table><br>
        <input type="submit" value="Buscar" class="btn btn-primary">
      </fieldset>
    </form>
  </body>
</html>
