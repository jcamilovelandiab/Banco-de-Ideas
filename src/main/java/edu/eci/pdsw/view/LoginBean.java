package edu.eci.pdsw.view;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import edu.eci.pdsw.samples.services.ServicesException;
import edu.eci.pdsw.samples.services.impl.*;

import edu.eci.pdsw.entities.*;


@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
public class LoginBean {
	
	private static final long serialVersionUID = 3594009161252782831L;
	
	@Inject
	private IdeasServicesImpl services;
	
	public void login(String correo) throws IOException, ServicesException{
			System.out.println(correo);
			Usuario user = services.consultarUsuario(correo);
            if (user.getTipo().equals(Rol.ADMINISTRADOR)) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("adminitracion.xhtml");
            }
            
        
		
	}

	


}
