/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import dao.Employeedao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.Employee;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class EmpFManagedBean {

    private Employee em = new Employee();

    public EmpFManagedBean() {
    }

    public Employee getEm() {
        return em;
    }

    public void setEm(Employee em) {
        this.em = em;
    }

    public void save() {
        Employeedao dao = new Employeedao();
        boolean status = dao.saveEmployee(em);
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Data saved", null));
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect("view.xhtml");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Data not saved", null));
        }
    }

    public List<Employee> viewem() {
        Employeedao dao = new Employeedao();
        List<Employee> emlist = dao.getAllemp();
        return emlist;

    }

    public void delete(int id) {
        Employeedao dao = new Employeedao();
        boolean status = dao.deleteemp(id);
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Data deleted", null));
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect("view.xhtml");
            } catch (Exception e) {
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Data not deleted", null));
        }
    }

    public void editemp(int id) {
        Employeedao dao = new Employeedao();
        em = dao.getById(id);
        if (em != null) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("em", em);
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect("edit.xhtml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Data not found", null));
        }

    }
}
