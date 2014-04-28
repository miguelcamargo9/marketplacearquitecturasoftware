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
    <link href="librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
      function f_buscarOferta() {
        $.ajax({
          url: 'buscarOfertaServlet',
          type: "POST",
          dataType: "html",
          data: {descripcion:"algo"},
          success: function(data) {
            cambiarOfertas(data);
          }
        });
      }
      function cambiarOfertas(datos) {
        

      }
    </script>
    <title>MarketPlace</title>
  </head>
  <body>
    <form class="form-horizontal" action="comprarOfertaServlet" method="post">
      <input type="hidden" name="idUsuario" value="<%=idUsuario%>">
      <fieldset>  
        <legend>Ofertas</legend>
        <table class="table table-hover">
          <tr>
            <td width="10%">Buscar: </td>
            <td width="90%">
              <input type="text" class="form-control" name="descripcion" placeholder="Descripcion..." id="descripcion">
            </td>
          </tr>
          <tr>
            <td>
              <input type="button" value="Buscar" class="btn btn-success" onclick="f_buscarOferta()">
            </td>
          </tr>
        </table><br>

        <div class="col-md-9">
          <div class="row" id="contenedor">
            <%=grillaCompras%>
          </div>
        </div>
        <input type="submit" value="Comprar" class="btn btn-primary">
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
</body>
</html>
