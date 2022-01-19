/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet(urlPatterns = {"/VerProcesso"})
public class VerProcesso extends HttpServlet {

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
        out.println("<title>Ver Processo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Ver Processo</h1>");

        String id = request.getParameter("id");

        Connection con;
        PreparedStatement stmt;
        String query, queryAF, queryAJ, queryRF, queryRJ;
        ResultSet rs, rsAF, rsAJ, rsRF, rsRJ;

        try {
            con = Conexao.conectar();
            query = "SELECT idProcesso, numeroProcesso, dataAjuizamento, valorCausa, tipoAcao, ritoAcao, comarca FROM Processo WHERE idProcesso = " + id;
            queryAF = "SELECT PF.nome FROM Processo_has_PessoaFisica_AUTOR INNER JOIN PessoaFisica PF ON PessoaFisica_idPessoaFisica = PF.idPessoaFisica WHERE Processo_idProcesso = " + id;
            queryAJ = "SELECT razao FROM Processo_has_PessoaJuridica_AUTOR INNER JOIN PessoaJuridica PJ ON PessoaJuridica_idPessoaJuridica = PJ.idPessoaJuridica WHERE Processo_idProcesso = " + id;
            queryRF = "SELECT nome FROM Processo_has_PessoaFisica_REU INNER JOIN PessoaFisica PF ON PessoaFisica_idPessoaFisica = PF.idPessoaFisica WHERE Processo_idProcesso = " + id;
            queryRJ = "SELECT razao FROM Processo_has_PessoaJuridica_REU INNER JOIN PessoaJuridica PJ ON PessoaJuridica_idPessoaJuridica = PJ.idPessoaJuridica WHERE Processo_idProcesso = " + id;

            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery(query);

            // Preparando a lista de autores
            String autores = "";
            stmt = con.prepareStatement(queryAF);
            rsAF = stmt.executeQuery(queryAF);
            while (rsAF.next()) {
                if (autores.equals("")) {
                    autores = rsAF.getString("nome");
                } else {
                    autores += ", " + rsAF.getString("nome");
                }
            }
            stmt = con.prepareStatement(queryAJ);
            rsAJ = stmt.executeQuery(queryAJ);
            while (rsAJ.next()) {
                if (autores.equals("")) {
                    autores = rsAJ.getString("razao");
                } else {
                    autores += ", " + rsAJ.getString("razao");
                }
            }
            // Preparando a lista de réus
            String reus = "";
            stmt = con.prepareStatement(queryRF);
            rsRF = stmt.executeQuery(queryRF);
            while (rsRF.next()) {
                if (reus.equals("")) {
                    reus = rsRF.getString("nome");
                } else {
                    reus += ", " + rsRF.getString("nome");
                }
            }
            stmt = con.prepareStatement(queryRJ);
            rsRJ = stmt.executeQuery(queryRJ);
            while (rsRJ.next()) {
                if (reus.equals("")) {
                    reus = rsRJ.getString("razao");
                } else {
                    reus += ", " + rsRJ.getString("razao");
                }
            }
            out.println("<table>");
            if (rs.next()) {
                out.println("<tr><td colspan=100><h2>Processo " + rs.getString("numeroProcesso") + "</h2></td></tr>");
                out.println("<tr><td colspan=100><a href='adicionar_autor.jsp?id=" + id + "' class='botao'>Adicionar Autor</a> <a href='adicionar_reu.jsp?id=" + id + "' class='botao'>Adicionar R&eacute;u</a></td></tr>");

                out.println("<tr><td>N&uacute;mero do processo: </td><td>" + rs.getString("numeroProcesso") + "</td></tr>");
                out.println("<tr><td>Data do ajuizamento: </td><td>" + rs.getString("dataAjuizamento") + "</td></tr>");
                out.println("<tr><td>Valor da causa: </td><td>" + rs.getString("valorCausa") + "</td></tr>");
                out.println("<tr><td>Tipo da a&ccedil;&atilde;o: </td><td>" + rs.getString("tipoAcao") + "</td></tr>");
                out.println("<tr><td>Rito da a&ccedil;&atilde;o: </td><td>" + rs.getString("ritoAcao") + "</td></tr>");
                out.println("<tr><td>Comarca: </td><td>" + rs.getString("comarca") + "</td></tr>");
                out.println("<tr><td>Autor(es): </td><td>" + autores + "</td></tr>");
                out.println("<tr><td>R&eacute;u(s): </td><td>" + reus + "</td></tr>");
            }
            out.println("</table>");
            
            query = "SELECT dataLancada, descricao, setor, tipo FROM Andamento WHERE Processo_idProcesso = " + id;            

            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            out.println("<table border='0'>");
            out.println("<tr><td colspan=100><h2>Andamentos</h2></td></tr>");
            out.println("<tr><td colspan=100><a href='adicionar_andamento.jsp?id=" + id + "'>Adicionar Andamento</a></td></tr>");
            while (rs.next()) {
                out.println("<tr><td>Data lan&ccedil;ada: </td><td>" + rs.getString("dataLancada") + "</td></tr>");
                out.println("<tr><td>Descri&ccedil;&atilde;o: </td><td>" + rs.getString("descricao") + "</td></tr>");
                out.println("<tr><td>Setor: </td><td>" + rs.getString("setor") + "</td></tr>");
                out.println("<tr><td>Tipo: </td><td>" + rs.getString("tipo") + "</td></tr>");   
                out.println("<tr><td colspan='100'><hr></td></tr>");      
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
