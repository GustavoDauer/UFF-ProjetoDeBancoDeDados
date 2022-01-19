<%-- 
    Document   : adicionar_andamento
    Created on : 03/01/2014, 18:58:04
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Adicionar Andamento</h1>
        <form action="AdicionarAndamento?id=<%= request.getParameter("id") %>" method="POST">           
            <table>
                <tr><td>Data lan&ccedil;amento: </td> 
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
                <tr><td>Descri&ccedil;&atilde;o: </td> <td><textarea name="descricao"></textarea></td></tr>            
                <tr><td>Tipo: </td> 
                    <td>
                        <select name="tipo">
                            <option value="Prazo" selected="selected">Prazo</option>
                            <option value="Peticao">Peti&ccedil;&atilde;o</option>
                            <option value="Custas">Custas</option>
                        </select>
                    </td>
                </tr>             
                <tr><td>Setor: </td> 
                    <td>
                        <select name="setor">
                            <option value="Juridico" selected="selected">Jur&iacute;dico</option>
                            <option value="Administrativo">Administrativo</option>
                            <option value="Financeiro">Financeiro</option>
                        </select>
                    </td>
                </tr>                                            
                <tr><td></td><td><input type="submit" value="Adicionar" /></td></tr>
            </table>  
        </form>
    </body>
</html>
