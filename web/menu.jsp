<%-- 
    Document   : menu
    Created on : 05-mar-2014, 12:32:46
    Author     : open12
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String nombreUsuario = null;
  nombreUsuario = (String) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <link href="librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
          <script type="text/javascript" src="librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
          <title>Bienvenido <%=nombreUsuario%></title>
     </head>
     <body>

     </body>
</html>
