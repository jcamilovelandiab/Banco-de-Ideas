package edu.eci.pdsw.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import edu.eci.pdsw.entities.*;
import edu.eci.pdsw.samples.services.ServicesException;
import edu.eci.pdsw.samples.services.ServicesIdeas;
import edu.eci.pdsw.samples.services.impl.ServicesIdeasImpl;


@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativaBean")
@RequestScoped

public class IniciativaBean extends BasePageBean{
	@ManagedProperty(value = "#{param.nombre}")
	private String nombre;
	
	
	private static final long serialVersionUID = 3594009161252782831L;
	
	@Inject
	private ServicesIdeas services;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Iniciativa> pal(String palabra) throws ServicesException{
		System.out.println((List<Iniciativa>) services.consultarIniciativas(palabra));
		return (List<Iniciativa>) services.consultarIniciativas(palabra);
	}
	
	
	public Collection<Iniciativa> getDatas(String keyword)throws ServicesException {
		List<String> vamos = new ArrayList<>();
		vamos.add(keyword);
		try {
			return services.consultarIniciativasxClaves(vamos);
		} catch (ServicesException e) {
			throw new ServicesException("mAMDAS");
		}
	}
}
