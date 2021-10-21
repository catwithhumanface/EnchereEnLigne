/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enchere.model;

/**
 *
 * @author liely
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DbConnexionManager  {
    
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3307/encheres";
    private final static String USERNAME = "root";
    
    /* Use for INSERT, UPDATE or DELETE queries */
    public static int executeUpdate(String updateQuery) {
        int rowCount = 0;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            rowCount = statement.executeUpdate(updateQuery);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeObjects(connection, statement);
        }
        return rowCount;
    }
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, "");
    }
    
    public static void closeObjects(Connection connection, Statement statement) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
        
