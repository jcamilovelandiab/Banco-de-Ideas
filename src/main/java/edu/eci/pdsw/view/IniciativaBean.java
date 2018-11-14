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
	public List<String> getClaves() {
		return claves;
	}

	public void setClaves(List<String> claves) {
		this.claves = claves;
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
		//System.out.println(claves);
		try {
			System.out.println(services.consultarIniciativasxClaves(claves));
			iniciativas=new ArrayList(services.consultarIniciativasxClaves(claves));
			System.out.println(iniciativas.get(0).getNombre());
		} catch (ServicesException e) {
			e.printStackTrace();
		}
	}

	public List<Iniciativa> getIniciativas() {
		return iniciativas;
	}

	public void setIniciativas(List<Iniciativa> iniciativas) {
		this.iniciativas = iniciativas;
	}
	public Iniciativa getDescripcion() throws ServicesException{
            for (Iniciativa i: iniciativas){
                return services.consultarIniciativa(i.getNombre());
            }
            return iniciativas.get(0);
        }
	
}
