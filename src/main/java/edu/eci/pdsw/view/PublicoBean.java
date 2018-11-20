package edu.eci.pdsw.view;

import edu.eci.pdsw.entities.Comentario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.samples.services.ServicesException;
import edu.eci.pdsw.samples.services.ServicesIdeas;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "publicoBean")
@RequestScoped
public class PublicoBean extends BasePageBean {
	
	
	private static final long serialVersionUID = 3594009161252782831L;
	
	@Inject
	private ServicesIdeas services;

	
	
        

}
