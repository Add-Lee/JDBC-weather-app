/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weatherprj;

import java.sql.*;

/**
 *
 * @author Adly
 */
public class JDBCUtil {

    public static String ConnectionString;

    public static Connection ConnectDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(ConnectionString,"root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
