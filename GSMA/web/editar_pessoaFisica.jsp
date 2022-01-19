<%-- 
    Document   : editar_pessoaFisica
    Created on : 04/01/2014, 00:52:28
    Author     : gustavo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Pessoa</title>
    </head>
    <body>
        <h1>Editar Pessoa F&iacute;sica</h1>
        <%
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BDSMADV_ALPHA", "root", "gustavo");

            PreparedStatement stmt;
            ResultSet rs;
            String query;

            String id = request.getParameter("id");
            String nome = null;
            String endereco = null;
            String telefone = null;
            String email = null;
            String cpf_cnpj = null;

            query = "SELECT nome, endereco, telefone, email, cpf FROM PessoaFisica WHERE idPessoaFisica=" + id;

            try {
                stmt = con.prepareStatement(query);
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    nome = rs.getString("nome");
                    endereco = rs.getString("endereco");
                    telefone = rs.getString("telefone");
                    email = rs.getString("email");
                    cpf_cnpj = rs.getString("cpf");
                }
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        %>
        <form action="EditarPessoaFisica?id=<%= id%>" method="POST">
            <table>
                <tr><td>Nome / Raz&atilde;o: </td> <td><input type="text" name="nome" value="<%=nome%>" /></td></tr>            
                <tr><td>Endere&ccedil;o: </td> <td><input type="text" name="endereco" value="<%=endereco%>" /></td></tr>            
                <tr><td>Telefone: </td> <td><input type="text" name="telefone" value="<%=telefone%>" /></td></tr>             
                <tr><td>Email: </td> <td><input type="text" name="email" value="<%=email%>" /></td></tr>                            
                <tr><td>CPF / CNPJ: </td> <td><input type="text" name="cpf_cnpj" value="<%=cpf_cnpj%>" /></td></tr>                       
                <tr><td></td><td><input type="submit" value="Editar" /></td></tr>
            </table>  
        </form>
    </body>
</html>
