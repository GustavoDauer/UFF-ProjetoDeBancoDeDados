<%-- 
    Document   : adicionar_reu
    Created on : 03/01/2014, 18:39:46
    Author     : gustavo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
        <h1>Adicionar R&eacute;u</h1>
        <form action="AdicionarReu?id=<%= request.getParameter("id")%>" method="POST">           
            <table>                
                <tr><td>Pessoas F&iacute;sicas cadastradas: </td> 
                    <td>
                        <select name="reuFisico">    
                            <option value="Nenhum">Nenhum</option>
                            <%
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BDSMADV_ALPHA", "root", "gustavo");
                                PreparedStatement stmt;
                                String query;

                                query = "SELECT idPessoaFisica, nome FROM PessoaFisica";
                                stmt = con.prepareStatement(query);
                                ResultSet rs = stmt.executeQuery(query);                
                                while(rs.next()) {
                                    out.println("<option value='" + rs.getString("idPessoaFisica") + "'>" + rs.getString("nome") + "</option>");
                                }                                
                            %>                            
                        </select>                        
                    </td>
                </tr>     
                <tr><td>Pessoas Jur&iacute;dicas cadastradas: </td> 
                    <td>
                        <select name="reuJuridico">      
                            <option value="Nenhum">Nenhum</option>
                            <%
                                query = "SELECT idPessoaJuridica, razao FROM PessoaJuridica";
                                stmt = con.prepareStatement(query);
                                rs = stmt.executeQuery(query);
                                while(rs.next()) {
                                    out.println("<option value='" + rs.getString("idPessoaJuridica") + "'>" + rs.getString("razao") + "</option>");
                                }                                
                            %>                            
                        </select><br />                        
                    </td>
                </tr>     
                <tr><td></td><td><input type="submit" value="Adicionar" /></td></tr>
            </table>  
        </form>
    </body>
</html>
