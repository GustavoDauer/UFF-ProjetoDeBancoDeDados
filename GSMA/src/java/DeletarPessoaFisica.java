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
@WebServlet(urlPatterns = {"/DeletarPessoaFisica"})
public class DeletarPessoaFisica extends HttpServlet {

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
        out.println("<head>");
        out.println("<title>Deletar Pessoas</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Deletar Pessoas</h1>");

        Connection con;
        PreparedStatement stmt;
        String query;

        try {
            con = Conexao.conectar();

            String id = request.getParameter("id");
            
            query = "DELETE FROM PessoaFisica WHERE idPessoaFisica=" + id;
            stmt = con.prepareStatement(query);            
            stmt.executeUpdate(query);
            
            response.sendRedirect("/GSMA/ListarPessoas");
            
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
