/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import com.sun.prism.impl.BaseMesh;
import dao.Studentdao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
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
    public String saveStudent(){
        Studentdao dao=new Studentdao();
        boolean status=dao.addStudent(stu);
        
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved.", " "));
            return "viewall.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Data not Saved", " "));
        }
    return null;
    }
    public List<Students> viewStudent(){
    Studentdao dao=new Studentdao();
    List<Students> allList=dao.getAllStudent();
    return allList;
    }
    public void  delete(int id){
    Studentdao dao=new Studentdao();
    boolean status=dao.deleteStudent(id);
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Successful", null));
            try {
                ExternalContext externalContext=FacesContext.getCurrentInstance().getExternalContext();
                externalContext.redirect("viewall.xhtml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Delete Unsuccessful", null));
        }
    }
    
    public String editStudent(int id){
    Studentdao dao=new Studentdao();
    stu=dao.getStudentById(id);
        if (stu !=null) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("stu", stu);
            return "editStudent.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Data not found",null));
            return null;
        }
    }
}
