/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Dbcon {
    private static Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/database";
    private static String user = "root";
    private static String password = "1234";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    
    public static Connection getCon() throws ClassNotFoundException, SQLException{
    Class.forName(driver);
    con=DriverManager.getConnection(url, user, password);
    return con;
    
    }
    
}
