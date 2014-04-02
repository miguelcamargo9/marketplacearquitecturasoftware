<%-- 
    Document   : validarCliente
    Created on : 10/03/2014, 05:13:43 PM
    Author     : Sebastian Rojas
--%>

<%@page import="com.marketPlace.modelo.usuarioModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String exito = "";
  String error = "";
  String listaUsuarios = "";
  usuarioModelo model = new usuarioModelo();
  model.crearListaUsuariosEstado(false);
  listaUsuarios = model.getListaSeleccionUsuario();
  exito = (String) session.getAttribute("exito");
  error = (String) session.getAttribute("error");
  exito = exito == null ? "": exito;
  error = error == null ? "": error;
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
    <title>Solicitudes de Clientes</title>
  </head>
  <body>
    <form class="form-horizontal" action="../validarUsuarioServlet" method="post">  
      <fieldset>  
        <legend>Solicitudes de Clientes</legend>
        <table class="table table-hover">
          <tr>
            <td width="10%">Usuarios Inscritos: </td>
            <td width="90%">
              <%=listaUsuarios%>
            </td>
          </tr>
        </table>
        <input type="submit" value="aceptar" class="btn btn-primary">
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
