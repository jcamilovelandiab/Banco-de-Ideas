package edu.eci.pdsw.view;
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
import edu.eci.pdsw.samples.services.ServicesIdeas;
import edu.eci.pdsw.samples.services.impl.*;

import edu.eci.pdsw.entities.*;


@SuppressWarnings("deprecation")
@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean extends BasePageBean {
	@ManagedProperty(value = "#{param.correo}")
	private String correo;
	private Usuario sr;
	
	private static final long serialVersionUID = 3594009161252782831L;
	
	@Inject
	private ServicesIdeas services;
	
	
	

	
	public String getCorreo(){
		System.out.println("Hola estamos aca" + this.correo);
		return this.correo;
	}
	public void setCorreo(String correo) {
		System.out.println("cORREO SET");
		this.correo = correo;
		System.out.println(this.correo);
		
	}
	
	public Usuario getNombre() throws ServicesException {
		System.out.println("Correo : "+ correo);
		try {
			Usuario sr=services.consultarUsuario(correo);
			System.out.println("holi ");
			System.out.println(sr.getNombre());
			return sr;
		} catch (ServicesException e) {
			throw new  ServicesException("a");
		}
	}
	
	


	
}
