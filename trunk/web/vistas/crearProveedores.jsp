<%-- 
    Document   : crearProveedores
    Created on : 6/03/2014, 11:57:40 PM
    Author     : Sebastian Rojas
--%>
<%@page import="com.marketPlace.modelo.usuarioModelo"%>
<%
  String listaUsuarios = null;
  usuarioModelo model = new usuarioModelo();
  model.crearListaUsuarios();
  listaUsuarios = model.getListaSeleccionUsuario();


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../js/jstree/dist/themes/default/style.min.css">
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
    <title>Creacion de Proveedores</title>
  </head>
  <body>
    <form class="form-horizontal" action="porveedorServlet" method="post">  
      <fieldset>  
        <legend>Creacion de Proveedores</legend>
        <table class="table table-hover">
          <tr>
            <td width="10%">Usuarios: </td>
            <td width="90%"><%=listaUsuarios%></td>
          </tr>
        </table>
        <input type="submit" value="enviar" class="btn btn-primary">
      </fieldset>  
    </form> 
  </body>
</html>
