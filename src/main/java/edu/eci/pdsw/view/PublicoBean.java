package edu.eci.pdsw.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.samples.services.ServicesIdeas;

@SuppressWarnings("deprecation")
@ManagedBean(name = "publicoBean")
@RequestScoped

public class PublicoBean extends BasePageBean {
	
	
	private static final long serialVersionUID = 3594009161252782831L;
	
	@Inject
	private ServicesIdeas services;

	private String opcion;

	public void setOpcion(String opcion){
		this.opcion = opcion;
	}


	public String getOpcion(){
		return this.opcion;
	}

	
        

}
