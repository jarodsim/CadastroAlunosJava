/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aluno.connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SERVER = "mysql://mysql03-farm10.kinghost.net";
    private static final String PORT = "3306";
    private static final String DATABASE = "md10";
    private static final String URL = "jdbc:mysql://mysql03-farm10.kinghost.net:3306/md10";
    private static final String USER = "md10";
    private static final String PASS = "uespi22";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão - sql", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro de conexão - driver", e);
        }

    }

    public static final void closeConnection(Connection con) {

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static final void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {
            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static final void closeConnection(Connection con, PreparedStatement stmt, ResultSet resultSet) {

        closeConnection(con, stmt);
        try {
            if (resultSet != null) {
                resultSet.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
