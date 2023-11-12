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
            se.save(s);
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

    public List<Students> getStudentById(int id) {
        List<Students> idList = new ArrayList<>();
        Students stu = new Students();
        Transaction tr = null;
        Session se = HibernateUtil.getSessionFactory().openSession();

        try {
            tr = se.beginTransaction();
            Query qu = se.createQuery("from Student where id= :id");
            stu = (Students) qu.uniqueResult();
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        } finally {
            se.close();
        }
        return idList;
    }
}
