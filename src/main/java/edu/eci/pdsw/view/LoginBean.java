package edu.eci.pdsw.view;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import edu.eci.pdsw.view.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.eci.pdsw.samples.services.ServicesException;
import edu.eci.pdsw.samples.services.impl.*;
import edu.eci.pdsw.samples.services.impl.ServicesIdeasImpl;
import edu.eci.pdsw.entities.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends BasePageBean {

    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    private ServicesIdeasImpl services;

    public void login(String correo) throws IOException, ServicesException {
    	Usuario user = services.consultarUsuario(correo);
    	FacesContext facesContext = FacesContext.getCurrentInstance();
        if (user != null) {
            HttpSession sesssion = (HttpSession) facesContext.getExternalContext().getSession(true);
            sesssion.setAttribute("correo", user.getCorreo());
            if (user.getTipo().equals(Rol.ADMINISTRADOR)) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("adminitracion.xhtml");
            } else if (user.getTipo().equals(Rol.PUBLICO)) {

                FacesContext.getCurrentInstance().getExternalContext().redirect("publico.xhtml?correo=" + correo);
            } else if (user.getTipo().equals(Rol.PROPONENTE)) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("proponente.xhtml?correo=" + correo);
            } else if (user.getTipo().equals(Rol.PMO_ODI)) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("PMO.xhtml?correo=" + correo);
            }
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
    }
    public void redirect(String correo) throws IOException{
    FacesContext.getCurrentInstance().getExternalContext().redirect("iniciativa.xhtml?correo=" + correo);
    }

}

