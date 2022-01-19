<%-- 
    Document   : index
    Created on : 28/12/2013, 00:39:54
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table width="100%" border="0">
            <tr>
                <td valign="top" colspan="2" height="100"><%@include file="topo.jsp" %></td>
            </tr>
            <tr>
                <td valign="top" width="170" height="700">
                    <%@include file="menu.jsp" %>
                </td>
                <td valign="top" width=""><iframe src="default.jsp" align="left" name="alvo" width="100%" height="100%" style="border: 1px"/></td>
            </tr>
        </table>
    </body>
</html>
