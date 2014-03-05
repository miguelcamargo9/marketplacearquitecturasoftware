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
          <title>JSP Page</title>
     </head>
     <body>
          <form action="loginServlet" method="post">
               <input name="nickname">
               <input name="password">
               <input type="submit" value="enviar">
          </form>
     </body>
</html>
