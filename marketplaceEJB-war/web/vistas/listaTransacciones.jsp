<%-- 
    Document   : listaTransacciones
    Created on : 28/04/2014, 02:03:26 AM
    Author     : Sebastian Rojas
--%>
<%@page import="java.util.List"%>
<%@page import="com.marketplace.entities.Transacciones"%>
<%
  List<Transacciones> listaTransacciones = (List<Transacciones>) session.getAttribute("listaTransacciones");
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
        Paquete
      </th>
      <th>
        Servicio
      </th>
      <th>
        Oferta
      </th>
      <th>
        fecha
      </th>
    </thead>
    <tbody>
      <%
        for (Transacciones transaccion : listaTransacciones) {
      %>
      <tr>
        <td>
          <%
            try {
              out.print(transaccion.getIdPaquete().getDescripcion());
            } catch (NullPointerException e) {
              out.print("Sin registros");
            }
          %>
        </td>
        <td>
          <%
            try {
              out.print(transaccion.getIdServicio().getDescripcion());
            } catch (NullPointerException e) {
              out.print("Sin registros");
            }
          %>
        </td>
        <td>
          <%
            try {
              out.print(transaccion.getIdOferta().getDescripcion());
            } catch (NullPointerException e) {
              out.print("Sin registros");
            }
          %>
        </td>
        <td>
          <%=transaccion.getFechaTransaccion()%>
        </td>
      </tr>
      <%
        }
      %>
    </tbody>
  </table>
</body>
</html>
