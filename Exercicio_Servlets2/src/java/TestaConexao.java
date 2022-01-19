
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class TestaConexao {
    public static void main(String args[]) throws SQLException {
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost/", "gustavo", "gustavo");
    }
}
