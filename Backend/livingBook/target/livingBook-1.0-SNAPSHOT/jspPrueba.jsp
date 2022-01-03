<%-- 
    Document   : jspPrueba
    Created on : 30/12/2021, 11:10:42
    Author     : phily
--%>

<%@page import="Modelo.Herramientas.Herramienta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%!Herramienta herramienta = new Herramienta();
            String path ="";
        %>
        
        <%if(true){
           path =  herramienta.establecerFotoPerfilPorDefecto("femenino");
        }%>
        
        <img src="<%=path%>" />
    </body>
</html>
