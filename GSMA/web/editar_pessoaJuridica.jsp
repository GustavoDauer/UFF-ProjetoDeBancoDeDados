<%-- 
    Document   : editar_pessoaJuridica
    Created on : 04/01/2014, 00:54:31
    Author     : gustavo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Pessoa</title>
    </head>
    <body>
        <h1>Editar Pessoa Jur&iacute;dica</h1>
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

            query = "SELECT razao, endereco, telefone, email, cnpj FROM PessoaJuridica WHERE idPessoaJuridica=" + id;

            try {
                stmt = con.prepareStatement(query);
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    nome = rs.getString("razao");
                    endereco = rs.getString("endereco");
                    telefone = rs.getString("telefone");
                    email = rs.getString("email");
                    cpf_cnpj = rs.getString("cnpj");
                }
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        %>
        <form action="EditarPessoaJuridica?id=<%= id%>" method="POST">
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
