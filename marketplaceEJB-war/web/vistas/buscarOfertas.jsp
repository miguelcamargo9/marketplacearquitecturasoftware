<%-- 
    Document   : buscarOfertas
    Created on : 10-mar-2014, 16:27:02
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
    <title>Buscar Ofertas</title>
  </head>
  <body>
    <!--<div class="container-fluid">-->   
      <div class="col-sm-6">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h3 class="panel-title">
              Buscar Ofertas
            </h3>
          </div>
          <div class="panel-body">
            <form action="../buscarOfertasServlet" method="post" class="form-horizontal" role="form">
              <div class="form-group">
                <input type="text" name="nombreOferta" placeholder="Descripcion de la Oferta" class="form-control" required>
              </div>
              <center>
                <input type="submit" class="btn btn-lg btn-info" value="Continuar">
              </center>
            </form>
          </div>
        </div>
      </div>
<!--      <div class="footer">
        desarrollado por:
        Sebastian Rojas
        Miguel Camargo
      </div>-->
    <!--</div>-->
  </body>
</html>
