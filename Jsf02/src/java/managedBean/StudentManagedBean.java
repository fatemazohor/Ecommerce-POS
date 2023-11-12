/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.Studentdao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Students;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class StudentManagedBean {

    /**
     * Creates a new instance of StudentManagedBean
     */
    private Students stu=new Students();
    
    public StudentManagedBean() {
        
    }

    public Students getStu() {
        return stu;
    }

    public void setStu(Students stu) {
        this.stu = stu;
    }
    public void saveStudent(){
        Studentdao dao=new Studentdao();
        boolean status=dao.addStudent(stu);
        
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved.", " "));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Data not Saved", " "));
        }
    
    }
    public List<Students> viewStudent(){
    Studentdao dao=new Studentdao();
    List<Students> allList=dao.getAllStudent();
    return allList;
    }
    
}
