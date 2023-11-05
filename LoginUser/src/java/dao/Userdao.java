/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import util.Dbcon;

/**
 *
 * @author user
 */
public class Userdao {

    public static int saveUser(User u) throws ClassNotFoundException, SQLException {
        int status = 0;
        String sql = "Insert into user(uid, fullName, userName, password, email) values(?,?,?,?,?)";
        PreparedStatement ps = Dbcon.getCon().prepareStatement(sql);
        ps.setString(1, u.getUid());
        ps.setString(2, u.getFullName());
        ps.setString(3, u.getUserName());
        ps.setString(4, u.getPassword());
        ps.setString(5, u.getEmail());
        status = ps.executeUpdate();
        ps.close();
        Dbcon.getCon().close();
        return status;

    }
    public static List<User> getAllUser() throws ClassNotFoundException, SQLException{
        List<User> list= new ArrayList<User>();
        String sql = "Select * From user";
        PreparedStatement ps = Dbcon.getCon().prepareStatement(sql);
        ResultSet rs= ps.executeQuery();
        while (rs.next()) {            
            User u= new User(rs.getString("uid"),
                    rs.getString("fullName"),
                    rs.getString("userName"),
                    rs.getString("password"),
                    rs.getString("email"));
            list.add(u);
            
        }
        rs.close();
        ps.close();
        Dbcon.getCon().close();
        return list;
    }
    
    public static int userLogin(User u) throws ClassNotFoundException, SQLException{
        int status=0;
        String sql="SELECT * FROM user where userName=? and password=?";
        PreparedStatement ps= Dbcon.getCon().prepareStatement(sql);
        ps.setString(1, u.getUserName());
        ps.setString(2, u.getPassword());
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {            
            status=1;
        }
        rs.close();
        ps.close();
        Dbcon.getCon().close();
        return status;
    
    }
}
