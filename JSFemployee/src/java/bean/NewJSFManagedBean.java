/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Employeedao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.Employees;

@ManagedBean
@SessionScoped
public class NewJSFManagedBean {

    Employees emp = new Employees();

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean() {

    }

    public Employees getEmp() {
        return emp;
    }

    public void setEmp(Employees emp) {
        this.emp = emp;
    }

    public void save() {
        Employeedao edao = new Employeedao();
        boolean status = edao.addemp(emp);
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Data saved", null));
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect("index.xhtml");
            } catch (Exception e) {
                e.printStackTrace();
            }
//            return "index.xhtml?face-redirect=true";

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Data Not saved", null));
        }
        
    }

    public List<Employees> viewAll() {
        Employeedao edao = new Employeedao();
        List<Employees> alist = edao.getAllemp();
        return alist;
    }

    public void deleteEmployee(int id) {
        Employeedao edao = new Employeedao();
        boolean status = edao.deleteemp(id);
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Data deleted", ""));
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect("index.xhtml");
            } catch (Exception e) {
                e.printStackTrace();

            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Data not deleted", ""));
        }
    }

    public void editemp(int id) {
        Employeedao edao = new Employeedao();
        emp = edao.getById(id);
        if (emp != null) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("emp", emp);
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect("edit.xhtml");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Data not found", ""));

        }

    }
}
