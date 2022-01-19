/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gustavo
 */
@WebServlet(urlPatterns = {"/ListarPessoas"})
public class ListarPessoas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"estilos.css\" />");
        out.println("<title>Listar Pessoas</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Listar Pessoas</h1>");

        Connection con;
        PreparedStatement stmt;
        String query;
        
        try {
            con = Conexao.conectar();
            out.println("<table>");
            out.println("<tr><td colspan=100><h2>Pessoas F&iacute;sicas</h2></td></tr>");
            
            query = "SELECT idPessoaFisica, nome FROM PessoaFisica";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString("nome") + "</td><td><a href='editar_pessoaFisica.jsp?id=" + rs.getInt("idPessoaFisica") + "'>Editar</a> <a href='DeletarPessoaFisica?id=" + rs.getInt("idPessoaFisica") + "'>Deletar</a></td></tr>");
            }
            rs.close();
            out.println("<tr><td colspan=100><h2>Pessoas Jur&iacute;dicas</h2></td></tr>");
            query = "SELECT idPessoaJuridica, razao FROM PessoaJuridica";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString("razao") + "</td><td><a href='editar_pessoaJuridica.jsp?id=" + rs.getInt("idPessoaJuridica") + "'>Editar</a> <a href='DeletarPessoaJuridica?id=" + rs.getInt("idPessoaJuridica") + "'>Deletar</a></td></tr>");
            }
            out.println("</table>");            
            rs.close();
            con.close();
        } catch (SQLException ex) {
            out.println("Erro SQL<br />" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            out.println("Erro Class");
        } catch (InstantiationException ex) {
            out.println("Erro Instanciação");
        } catch (IllegalAccessException ex) {
            out.println("Erro de Acesso Ilegal");
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
