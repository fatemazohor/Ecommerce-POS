/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Employees;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Employeedao {

    public boolean addemp(Employees emp) {

        Transaction t = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            t = s.beginTransaction();
            s.saveOrUpdate(emp);
            t.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.close();
        }

        return false;
    }

    public List<Employees> getAllemp() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Employees> elist = s.createQuery("SELECT e From Employees e").list();

        return elist;

    }

    public boolean deleteemp(int id) {
        Transaction t = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            t = s.beginTransaction();
            Employees ed = (Employees) s.load(Employees.class, id);
            s.delete(ed);
            t.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        } finally {
            s.close();
        }
        return false;
    }

    public Employees getById(int id) {
        Session s = null;
        Employees em = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            em = (Employees) s.get(Employees.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }
        return em;
    }
}
