<%-- 
    Document   : crearProveedores
    Created on : 6/03/2014, 11:57:40 PM
    Author     : Sebastian Rojas
--%>
<%
  String accion = null;
  accion = (String) session.getAttribute("accion");
  accion = accion.equals("cargardatos")?"cargardatos":accion;

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="js/jstree/dist/themes/default/style.min.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
    <title>Creacion de Proveedores</title>
  </head>
  <body>
    <form action="proveedorServlet" method="post">
    <input type="hidden" value="<%=accion%>" id="accion"> 
    <input type="submit" value="cargarDatos" class="btn btn-default">
    </form>
  </body>
</html>
