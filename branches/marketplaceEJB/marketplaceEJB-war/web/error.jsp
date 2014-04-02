<%-- 
    Document   : error
    Created on : 05-mar-2014, 12:33:03
    Author     : open12
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String error = null;
  error = (String) session.getAttribute("error");
%>
<!DOCTYPE html>
<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>JSP Page</title>
     </head>
     <body>
          <h1><%=error%></h1>
     </body>
</html>
