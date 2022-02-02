/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weatherprj.Area.Temperature;

/**
 *
 * @author Adly
 */
import java.sql.*;
import weatherprj.JDBCUtil;
import weatherprj.HelperFunctions.TempConverter;

public class Controller {

    public static boolean create(Reading r) throws SQLException {
        String query = "insert into WeatherDT values (" + "'" + r.area + "'" +','+r.celsius + ',' + TempConverter.cTf(r.fahrenheit) +")";
        return JDBCUtil.ConnectDB().prepareStatement(query).execute();
    }

    public static ResultSet read(String area) throws SQLException {
        String query = "SELECT area, Celsius, fahrenheit from WeatherDT where area=" + "'" + area + "'";
        ResultSet resultset = JDBCUtil.ConnectDB().createStatement().executeQuery(query);
        while (resultset.next()) {
            System.out.println(resultset.getString(2) + " " + resultset.getString(3));
        }
        return resultset;
    }

    public static boolean update(String area, double temp) throws SQLException {
        String query = "update WeatherDT set Celsius=" + temp
                 + " ,fahrenheit= " + TempConverter.cTf(temp)
                + " where area=" + "'" + area + "'";
        System.out.println(query);
        return JDBCUtil.ConnectDB().prepareStatement(query).execute();
    }

    public static boolean delete(String area) throws SQLException {
        String query = "delete from WeatherDT where area = " + "'" + area + "'";
        return JDBCUtil.ConnectDB().prepareStatement(query).execute();
    }
}
