/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author user
 */
public class Employeedao {
    
    public boolean saveEmployee(Employee emp){
        Transaction t=null;
        Session s=HibernateUtil.getSessionFactory().openSession();
        
        try {
            t=s.beginTransaction();
            s.saveOrUpdate(emp);
            t.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        } finally{
            s.close();
        }
        return false;
    }
    
    public List<Employee> getAllemp(){
        Session s=HibernateUtil.getSessionFactory().openSession();
        List<Employee> elist=s.createQuery("Select e From Employee e").list();
        return elist;
    
    }
    public boolean deleteemp(int id){
    Transaction t=null;
        Session s=HibernateUtil.getSessionFactory().openSession();
        Employee emp=new Employee();
        try {
            t=s.beginTransaction();
            emp=(Employee) s.load(Employee.class, id);
            s.delete(emp);
            t.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }finally{
            s.close();
        }
        return false;
    }
    public Employee getById(int id){
        Employee em=new Employee();
        Session s=HibernateUtil.getSessionFactory().openSession();
        try {
            em=(Employee) s.get(Employee.class, id);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return em;
    }
}
