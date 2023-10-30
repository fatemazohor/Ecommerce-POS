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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import util.DbCon;

public class Studentdao {

    //Data Access Object (dao);
    public static int saveStudent(Student s) {
        int status = 0;
        String sql = "Insert into student( sName, email, password, gender, address, city, state, zip) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DbCon.getCon().prepareStatement(sql);
            ps.setString(1, s.getsName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());
            ps.setString(4, s.getGender());
            ps.setString(5, s.getAddress());
            ps.setString(6, s.getCity());
            ps.setString(7, s.getState());
            ps.setString(8, s.getZip());
            status = ps.executeUpdate();
            System.out.println("result " + s.toString());
            System.out.println("status " + status);
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public static List<Student>getAllRecords() {
        List<Student> list = new ArrayList<Student>();
        String sql="SELECT * FROM  student";
        PreparedStatement ps;
        try {
            ps = DbCon.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Student s= new Student(rs.getInt("idstudent"),
                        rs.getString("sName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Studentdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return list;

    }
}
