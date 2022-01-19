<%-- 
    Document   : adicionar_pessoa
    Created on : 02/01/2014, 21:30:45
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Pessoa</title>
    </head>
    <body>
        <h1>Adicionar Pessoa</h1>
        <form action="AdicionarPessoa" method="POST">
            <table>
                <tr><td>Nome / Raz&atilde;o: </td> <td><input type="text" name="nome" /></td></tr>            
                <tr><td>Endere&ccedil;o: </td> <td><input type="text" name="endereco" /></td></tr>            
                <tr><td>Telefone: </td> <td><input type="text" name="telefone" /></td></tr>             
                <tr><td>Email: </td> <td><input type="text" name="email" /></td></tr>            
                <tr><td>Pessoa F&iacute;sica <input type="radio" name="tipo" value="fisica" checked="checked"/> </td> <td>Pessoa Jur&iacute;dica <input type="radio" name="tipo" value="juridica" /></td></tr>            
                <tr><td>CPF / CNPJ: </td> <td><input type="text" name="cpf_cnpj" /></td></tr>                       
                <tr><td></td><td><input type="submit" value="Adicionar" /></td></tr>
            </table>  
        </form>
    </body>
</html>
