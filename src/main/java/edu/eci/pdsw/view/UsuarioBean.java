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
public class UsuarioBean {
	@ManagedProperty(value = "#{param.correo}")
	private String correo;
	
	private static final long serialVersionUID = 3594009161252782831L;
	
	@Inject
	private ServicesIdeas services;
	
	
	private String nombre;

	
	public String getCorreo(){
		System.out.println("Hola estamos aca" + this.correo);
		return this.correo;
	}
	public void setCorreo(String correo) {
		System.out.println("cORREO SET");
		this.correo = correo;
		System.out.println(this.correo);
		
	}
	
	public String getNombre(String correo) throws ServicesException {
		System.out.println("Correo : "+ correo);
		try {
			System.out.println(services.consultarUsuario("john.ibanez@mail.escuelaing.edu.co"));
			return "Hola mundo";
		} catch (ServicesException e) {
			throw new  ServicesException("a");
		}
	}
	
	


	
}
