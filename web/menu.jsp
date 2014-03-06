<%-- 
    Document   : menu
    Created on : 05-mar-2014, 12:32:46
    Author     : open12
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String nombreUsuario = null;
  String apellidoUsuario = null;
  String perfil = null;
  nombreUsuario = (String) session.getAttribute("usuario");
  apellidoUsuario = (String) session.getAttribute("apellido");
  perfil = (String) session.getAttribute("perfil");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="js/jstree/dist/themes/default/style.min.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jstree/dist/jstree.min.js"></script>
    <script type="text/javascript" src="librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function() {
        f_enviar();
      });
      function f_enviar() {
        $.ajax({
          url: 'menuServlet',
          type: "POST",
          dataType: "json",
          data: {perfil:<%=perfil%>},
          success: function(data) {
            crearArbol(data);
          }
        });
      }
      function crearArbol(data) {
        $('#jstree').jstree("destroy");
        $('#jstree').jstree({
          "plugins": ["json_data"],
          'core': {
            "data": data
          }
        });
      }

      function f_link(enlace) {
        var frame = $("#contenido");
        frame.attr("src", enlace);
      }
    </script>
    <script type="text/css">
      html, body {
        height:100%;
      }
    </script>
    <title>Bienvenido <%=nombreUsuario + " " + apellidoUsuario%> </title>
  </head>
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">MarketPlace</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Bienvenido <%=nombreUsuario + " " + apellidoUsuario%> </a></li>
            <li>
            <li>
              <form class="navbar-form navbar-right" action="salirServlet" method="post">
                <input type="submit" class="btn btn-sm btn-link" name="salir" value="salir">
              </form>
            </li>
            </li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search..." name="busqueda">
          </form>
        </div>
      </div>
    </div>
    <div class="jumbotron">
      <div class="row">
        <div class="col-md-3">
          <div id="jstree">

          </div>
        </div>
        <div class="col-md-9">
          <iframe id="contenido" width="100%" height="100%">
          </iframe>
        </div>
      </div>
    </div>
  </body>
</html>
