/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package weatherprj;

import java.sql.SQLException;
import weatherprj.Area.Temperature.Controller;
import weatherprj.Area.Temperature.Reading;
import weatherprj.HelperFunctions.TempConverter;

/**
 *
 * @author Adly
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        JDBCUtil.ConnectionString = "jdbc:mysql://localhost:3306/WeatherDB";

        Controller.create(new Reading("test", 40, TempConverter.cTf(40)));
        System.out.println(Controller.read("test"));
        Controller.update("test", 55);
        Controller.delete("test");


    }

}
