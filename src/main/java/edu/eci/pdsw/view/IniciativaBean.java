package edu.eci.pdsw.view;

import edu.eci.pdsw.entities.Estado;
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
import edu.eci.pdsw.entities.Iniciativa;
import edu.eci.pdsw.samples.services.ServicesException;
import edu.eci.pdsw.samples.services.ServicesIdeas;
import edu.eci.pdsw.samples.services.impl.ServicesIdeasImpl;


@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativaBean")
@RequestScoped
public class IniciativaBean extends BasePageBean{
	
	@ManagedProperty(value = "#{param.nombre}")
	private String nombre;
	private List<String> claves;
	private List<Iniciativa> iniciativas;
    private Iniciativa selectIniciativa;
        
        
	public List<String> getClaves() {
		return claves;
	}

	public void setClaves(List<String> claves) {
		if(claves == null) {
			this.claves = new ArrayList<String>();
		}else {
			this.claves = claves;
		}
	}
	


	private static final long serialVersionUID = 3594009161252782831L;
	
	@Inject
	private ServicesIdeas services;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void getDatas()throws ServicesException {
		try {
			iniciativas=new ArrayList(services.consultarIniciativasxClaves(claves));
		} catch (ServicesException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Iniciativa> getIniciativas() {
		return iniciativas;
	}

	public void setIniciativas(List<Iniciativa> iniciativas) {
		this.iniciativas = iniciativas;
	}

    public Iniciativa getSelectIniciativa() {
        
        return selectIniciativa;
    }

    public void setSelectIniciativa(Iniciativa selectIniciativa) {
        this.selectIniciativa = selectIniciativa;
    }
    public void cambioEstado(String nombre, String e) throws ServicesException{
        if(e.equals("EN_ESPERA"))services.modificarEstado(nombre, Estado.EN_ESPERA);
        else if(e.equals("DESECHADO"))services.modificarEstado(nombre, Estado.DESECHADO);
        if(e.equals("EN_REVISION"))services.modificarEstado(nombre, Estado.EN_REVISION);
        if(e.equals("PROYECTO"))services.modificarEstado(nombre, Estado.PROYECTO);
        else services.modificarEstado(nombre, Estado.SOLUCIONADO);
    }

        
    public List<Iniciativa>  inivs() throws ServicesException{
       
		return (List<Iniciativa>)  services.consultarIniciativas();
	}


	public List<Iniciativa> getPrueba() throws ServicesException{
		List<Iniciativa> tmp;
		try {
			tmp = (List<Iniciativa>) services.consultarIniciativas();
			return tmp;
		} catch (ServicesException e) {
			 throw new ServicesException("ERROR AL TOMAR LA INICIATIVA");
		}
		
	}


	
}
