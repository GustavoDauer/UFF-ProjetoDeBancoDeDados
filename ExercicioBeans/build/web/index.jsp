<%-- 
    Document   : index
    Created on : 05/01/2014, 20:48:37
    Author     : gustavo
--%>

<%@page import="Modelo.Processo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="processo" class="Modelo.Processo"  />
        <jsp:setProperty name="processo" property="numero" value="2014" />
        <%
            out.println(processo.getNumero());
        %>
    </body>
</html>
