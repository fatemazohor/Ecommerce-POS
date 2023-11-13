package dao;

import java.util.ArrayList;
import java.util.List;
import model.Students;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Studentdao {

    public boolean addStudent(Students s) {
        Transaction tr = null;
        Session se = HibernateUtil.getSessionFactory().openSession();
        try {
            tr = se.beginTransaction();
            se.saveOrUpdate(s);
            tr.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        } finally {
            se.close();
        }
        return false;
    }

    public List<Students> getAllStudent() {

        Transaction tr = null;
        Session se = HibernateUtil.getSessionFactory().openSession();
        List<Students> stuList = se.createQuery("SELECT s FROM Students s").list();
        //Students is model> java.class
        return stuList;
    }

    public Students getStudentById(int id) {
        Session se=null;
        Students stud=null;
        try {
           se=HibernateUtil.getSessionFactory().openSession();
           stud=(Students) se.get(Students.class, id);
           
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (se !=null) {
                    se.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return stud;
    }
    public boolean deleteStudent(int id){
    Transaction tr=null;
    Session se=HibernateUtil.getSessionFactory().openSession();
        try {
            tr=se.beginTransaction();
            Students stud=(Students) se.load(Students.class, new Integer(id));
            se.delete(stud);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    return false;
    }
    
}
