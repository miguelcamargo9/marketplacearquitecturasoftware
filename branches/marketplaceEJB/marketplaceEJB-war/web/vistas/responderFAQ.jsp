<%-- 
    Document   : responderFAQ
    Created on : 27-abr-2014, 19:16:26
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.marketPlace.modelo.preguntasModelo"%>
<!DOCTYPE html>
<%
  String perfil = "";
  perfil = (String) session.getAttribute("perfil");
  perfil = perfil == null ? "" : perfil;
  String idUsuario = "";
  idUsuario = (String) session.getAttribute("idUsuario");
  idUsuario = idUsuario == null ? "" : idUsuario;
  int idUsr = Integer.parseInt(idUsuario);
  String listaPreguntas = "";
  preguntasModelo model = new preguntasModelo();
  model.crearListaPreguntasEstado(true, idUsr);
  listaPreguntas = model.getListaSeleccionPreguntasEstado();
  String mensaje = "";
  mensaje = (String) session.getAttribute("mensaje");
  mensaje = mensaje == null ? "" : mensaje;
  String error = "";
  error = (String) session.getAttribute("error");
  error = error == null ? "" : error;
%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
    <title>FAQ</title>
  </head>
  <body>
    <div class="col-sm-6">
      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">
            FAQ
          </h3>
        </div>
        <div class="panel-body">
          <form action="../preguntasServlet" method="post" class="form-horizontal" role="form">
            <div class="form-group">
              Seleccione Preguntas<%=listaPreguntas%>
            </div>
            <div class="form-group">
              <textarea class="form-control" name="respuestasFAQ" placeholder="Respuesta" required></textarea>
            </div>
            <center>
              <input type="submit" class="btn btn-lg btn-info" value="Continuar">
            </center>
          </form>
        </div>
      </div>
    <% if (!mensaje.equals("")) {
    %>
    <div class="alert alert-success">
      <strong>
        <%=mensaje%>
      </strong>
    </div>
    <%
      }
      if (!error.equals("")) {
    %>
    <div class="alert alert-danger">
      <strong>
        <%=error%>
      </strong>
    </div>
    <%
      }
      session.removeAttribute("error");
      session.removeAttribute("mensaje");
    %>
    </div>
  </body>
</html>
