/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.Studentdao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Students;

/**
 *
 * @author user
 */
@ManagedBean(name = "studentBean")
@RequestScoped
public class JSFManagedBean {

    /**
     * Creates a new instance of JSFManagedBean
     */
    public JSFManagedBean() {
        
    }
    public void save(){
        Students s=new Students();
        Studentdao dao= new Studentdao();
        dao.addStudent(s);
    
    }
}
