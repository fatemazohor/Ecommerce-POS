package dao;

import model.Students;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Studentdao {

    public void addStudent(Students s) {
        Transaction tr = null;
        Session se = HibernateUtil.getSessionFactory().openSession();
        try {
            tr = se.beginTransaction();
            se.save(s);
            tr.commit();
            System.out.println("Student daw addStudnet methode work");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
