<%-- 
    Document   : listaProveedores
    Created on : 28/04/2014, 01:01:53 AM
    Author     : Sebastian Rojas
--%>
<%@page import="com.marketplace.entities.Usuarios"%>
<%@page import="java.util.List"%>
<%
  List<Usuarios> listaProveedores = (List<Usuarios>) session.getAttribute("listaProveedores");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
  </head>
  <body>
    <table class="table table-hover">
      <thead>
      <th>
        Nombre comercial
      </th>
      <th>
        Correo
      </th>
    </thead>
    <tbody>
      <%
      for(Usuarios usuario:listaProveedores) {
        %>
        <tr>
          <td>
          <%=usuario.getNombreComercial()%>
          </td>
          <td>
          <%=usuario.getCorreo()%>
          </td>
        </tr>
        <%
      }
      %>
    </tbody>
  </table>
</body>
</html>
