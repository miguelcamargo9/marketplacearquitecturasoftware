<%-- 
    Document   : index
    Created on : 4/03/2014, 12:23:09 AM
    Author     : Sebastian Rojas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <link href="librerias/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
          <script type="text/javascript" src="librerias/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
          <title>JSP Page</title>
     </head>
     <body>
          <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
               <div class="container">
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
                         <form action="loginServlet" method="post" class="navbar-form navbar-right" role="form">
                              <div class="form-group">
                                   <input type="text" name="nickname" placeholder="nickname" class="form-control">
                              </div>
                              <div class="form-group">
                                   <input type="password" name="password" placeholder="password" class="form-control">
                              </div>
                              <input type="submit" class="btn btn-success" value="Ingresar">
                         </form>
                    </div><!--/.navbar-collapse -->
               </div>
          </div>
          <div class="jumbotron">
               <div class="container">
                    <h1>MarketPlace Turismo Ecologico</h1>
                    <p>Usted aqui podra encontrar ofertas, paquetes y servicios de diferentes proveedores para lograr unas vacaciones ecologicas unicas</p>

               </div>
          </div>
     </body>
</html>
