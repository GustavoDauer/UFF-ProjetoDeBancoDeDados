<%-- 
    Document   : index
    Created on : 28/12/2013, 00:39:54
    Author     : gustavo
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Adicionar Processo</h1>
        <form action="AdicionarProcesso" method="POST">           
            <table>
                <tr><td>N&uacute;mero do processo: </td> <td><input type="text" name="numero" value="123456789-00" /></td></tr>            
                <tr><td>Valor da causa: </td> <td>R$ <input type="text" name="valor" value="25000" /></td></tr>            
                <tr><td>Tipo da a&ccedil;&atilde;o: </td> 
                    <td>
                        <select name="tipo">
                            <option value="Cobranca" selected="selected">Cobran&ccedil;a</option>
                            <option value="Execucao">Execu&ccedil;&atilde;o</option>
                        </select>
                    </td>
                </tr>             
                <tr><td>Rito da a&ccedil;&atilde;o: </td> 
                    <td>
                        <select name="rito">
                            <option value="Ordinario" selected="selected">Ordin&aacute;rio</option>
                            <option value="Sumario">Sum&aacute;rio</option>
                        </select>
                    </td>
                </tr>                            
                <tr><td>Comarca / Regional / Vara: </td> 
                    <td>
                        <select name="comarca">                            
                            <option value="Rio de Janeiro - Capital" selected="selected">Rio de Janeiro - Capital</option>
                            <option value="Rio de Janeiro - Campos">Rio de Janeiro - Campos</option>
                        </select>
                    </td>
                </tr>    
                <tr><td>Data ajuizamento: </td> 
                    <td>
                        <select name="dia">                            
                            <script language="Javascript">                         
                                for (i = 1; i <= 31; i++) {
                                    document.write('<option value="' + i + '" selected="selected">' + i + '</option>');
                                }
                            </script>                     
                        </select>
                        <select name="mes">                            
                            <script language="Javascript">                         
                                for (i = 1; i <= 12; i++) {
                                    document.write('<option value="' + i + '" selected="selected">' + i + '</option>');
                                }
                            </script>                     
                        </select>
                        <select name="ano">                            
                            <script language="Javascript">                         
                                for (i = 2000; i <= 2014; i++) {
                                    document.write('<option value="' + i + '" selected="selected">' + i + '</option>');
                                }
                            </script>                     
                        </select>
                    </td>
                </tr>  
                <tr><td></td><td><input type="submit" value="Adicionar" /></td></tr>
            </table>  
        </form>
    </body>
</html>
