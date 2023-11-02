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

    public static int updateStudentById(Student s) throws SQLException {
        int status = 0;
        String sql = "update student set sName=?, email=? ,password=?, gender=?,"
                + " address=? ,city=? ,state=? ,zip=? where idstudent=?";
        PreparedStatement ps;
        ps = DbCon.getCon().prepareStatement(sql);
        ps.setString(1, s.getsName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getPassword());
        ps.setString(4, s.getGender());
        ps.setString(5, s.getAddress());
        ps.setString(6, s.getCity());
        ps.setString(7, s.getState());
        ps.setString(8, s.getZip());
        ps.setInt(9, s.getIdstudent());
        status = ps.executeUpdate();
        ps.close();

        DbCon.getCon().close();

        return status;

    }

    public static List<Student> getAllRecords() {
        List<Student> list = new ArrayList<Student>();
        String sql = "SELECT * FROM  student";
        PreparedStatement ps;
        try {
            ps = DbCon.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getInt("idstudent"),
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

    public static Student getStudentById(int Idstudent) throws SQLException {
        Student s = new Student();

        String sql = "SELECT * FROM  student Where idstudent=?";
        PreparedStatement ps;
        ps = DbCon.getCon().prepareStatement(sql);
        ps.setInt(1, Idstudent);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            s.setIdstudent(rs.getInt("idstudent"));
            s.setsName(rs.getString("sName"));
            s.setEmail(rs.getString("email"));
            s.setPassword(rs.getString("password"));
            s.setGender(rs.getString("gender"));
            s.setAddress(rs.getString("address"));
            s.setCity(rs.getString("city"));
            s.setState(rs.getString("state"));
            s.setZip(rs.getString("zip"));

        }
        ps.close();
        rs.close();
        DbCon.getCon().close();

        return s;
    }

    public static int deleteRecordsById(Student s) throws SQLException {
        int status = 0;
        String sql = "Delete FROM  student Where idstudent=?";
        PreparedStatement ps;
        ps = DbCon.getCon().prepareStatement(sql);
        ps.setInt(1, s.getIdstudent());
        status = ps.executeUpdate();

        ps.close();
        DbCon.getCon().close();
        return status;
    }
}
